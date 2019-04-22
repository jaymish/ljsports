package com.openTournament.controller;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openTournament.model.CollectorVO;
import com.openTournament.model.UserProfileVO;
import com.openTournament.service.CollectorService;
import com.openTournament.service.QRService;
import com.openTournament.service.UserEventsService;
import com.openTournament.service.UserProfileService;
import com.paytm.pg.merchant.CheckSumServiceHelper;

@Controller
public class PaytmGatewayController {
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	UserEventsService userEventsService;
	
	@Autowired
	CollectorService collectorService;
	
	@Autowired
	QRService qrService;
	
	HttpSession session;
	
	@RequestMapping(value="/user/payonline",method=RequestMethod.GET)
	public ModelAndView loadCheckoutDetails(HttpServletRequest request,@RequestParam(value="txn_amount") int txn_amount,UserProfileVO userDetails) throws Exception
	{
		session=request.getSession();
		userDetails = (UserProfileVO)session.getAttribute("profileDetails");
		String emailid = userDetails.getRegVO().getLoginVO().getUsername();
		Date date=new Date();
		String ordertime = date.toString();
		String OrderId = emailid+ordertime;
		String encOrderId=this.qrService.createMd5(OrderId);
		
		
		String merchantMid = "LJInst35711634445442";
		// Key in your staging and production MID available in your dashboard
		String merchantKey = "F!vWj_KuKSlUUf#V";
		// Key in your staging and production merchant key available in your dashboard
		String orderId = encOrderId;
		String channelId = "WEB";
		String custId = Integer.toString(userDetails.getProfileId());
		String mobileNo = userDetails.getContact();
		String email = emailid;
		String txnAmount = Integer.toString(txn_amount);
		String website = "WEBPROD";
		// This is the staging value. Production value is available in your dashboard
		String industryTypeId = "PrivateEducation";
		// This is the staging value. Production value is available in your dashboard
		String callbackUrl = "http://notion.ljinstitutes.org/user/paytmResponse/";
		ModelAndView modelAndView = new ModelAndView("redirect:https://securegw.paytm.in/theia/processTransaction");
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();
		paytmParams.put("MID",merchantMid);
		paytmParams.put("ORDER_ID",orderId);
		paytmParams.put("CHANNEL_ID",channelId);
		paytmParams.put("CUST_ID",custId);
		paytmParams.put("MOBILE_NO",mobileNo);
		paytmParams.put("EMAIL",email);
		paytmParams.put("TXN_AMOUNT",txnAmount);
		paytmParams.put("WEBSITE",website);
		paytmParams.put("INDUSTRY_TYPE_ID",industryTypeId);
		paytmParams.put("CALLBACK_URL", callbackUrl);
		String paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmParams);
		paytmParams.put("CHECKSUMHASH",paytmChecksum);
		modelAndView.addAllObjects(paytmParams);
		return modelAndView;
	}
	
	@RequestMapping(value="/user/paytmResponse",method=RequestMethod.POST)
	public String paytmResponse(HttpServletRequest request,UserProfileVO userProfileVO,CollectorVO collectorVO) throws Exception
	{
		final String merchantKey = "F!vWj_KuKSlUUf#V";
		String paytmChecksum = null;
		// Create a tree map from the form post param
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();
		// Request is HttpServletRequest
		for (Entry<String, String[]> requestParamsEntry : request.getParameterMap().entrySet()) {
		    if ("CHECKSUMHASH".equalsIgnoreCase(requestParamsEntry.getKey())){
		        paytmChecksum = requestParamsEntry.getValue()[0];
		    } else {
		        paytmParams.put(requestParamsEntry.getKey(), requestParamsEntry.getValue()[0]);
		    }
		}
		// Call the method for verification
		boolean isValidChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(merchantKey, paytmParams, paytmChecksum);
		// If isValidChecksum is false, then checksum is not valid
		if(isValidChecksum){
			System.out.println("Checksum Matched");
			session = request.getSession();
			userProfileVO = (UserProfileVO)session.getAttribute("profileDetails");
			
			String txn_date=paytmParams.get("TXNDATE");
			String status = paytmParams.get("STATUS");
			System.out.println(paytmParams.get("TXNAMOUNT"));
			int amount=(int)Float.parseFloat(paytmParams.get("TXNAMOUNT"));
			System.out.println(amount);
			List<UserProfileVO> profileData=this.userProfileService.getUserProfileById(userProfileVO);
			String nameOfUser=profileData.get(0).getRegVO().getFirstname()+" "+profileData.get(0).getRegVO().getLastname();
			collectorVO.setCollectorUsername("PayTM");
			collectorVO.setNameOfUser(nameOfUser);
			collectorVO.setTotalAmount(amount);
			collectorVO.setTime(txn_date);
			
			System.out.println(status);
			
			if(status.equals("TXN_SUCCESS"))
			{
				this.userEventsService.collectPayment(userProfileVO);
				this.collectorService.insertCollection(collectorVO);
				return "redirect:/user/viewEvents?payment=received";
			}
			else if(status.equals("TXN_FAILURE"))
			{
				return "redirect:/user/viewEvents?payment=failed";
			}
			else if(status.equals("PENDING"))
			{
				return "redirect:/user/viewEvents?payment=pending";
			}
			else
			{
				return "redirect:/user/viewEvents";
			}
			
		}else{
			System.out.println("Checksum MisMatch");
			return "redirect:/user/viewEvents?payment=exception";
		}
	}
	
	@RequestMapping(value="/admin/transactionStatus",method=RequestMethod.GET)
	public String loadtransactionStatus()
	{
		return "/admin/transactionStatus";
	}
	
	@RequestMapping(value="/admin/checkTransaction",method=RequestMethod.POST)
	public ModelAndView transactionStatus(HttpServletResponse response,@RequestParam("orderid") String orderid)throws IOException
	{
		PrintWriter out=response.getWriter();
		
		String transactionURL = "https://securegw.paytm.in/order/status";
		String merchantMid = "LJInst35711634445442";
		String orderId = orderid;
		String merchantKey = "F!vWj_KuKSlUUf#V";
		TreeMap<String, String> paytmParams = new TreeMap<String, String>();
		paytmParams.put("MID", merchantMid);
		paytmParams.put("ORDERID", orderId);
		try {
		    String paytmChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmParams);
		    paytmParams.put("CHECKSUMHASH", paytmChecksum);
		    JSONObject obj = new JSONObject();
		    obj.putAll(paytmParams);
		    String postData = "JsonData=" + obj.toString();
		    
		    URL url = new URL(transactionURL);
		    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		    connection.setRequestMethod("POST");
		    connection.setRequestProperty("contentType", "application/json");
		    connection.setUseCaches(false);
		    connection.setDoOutput(true);

		    DataOutputStream requestWriter = new DataOutputStream(connection.getOutputStream());
		    requestWriter.writeBytes( postData);
		    requestWriter.close();
		    String responseData = "";
		    InputStream is = connection.getInputStream();
		    BufferedReader responseReader = new BufferedReader(new InputStreamReader(is));
		    if((responseData = responseReader.readLine()) != null) {
		        System.out.append("Response Json = " + responseData);
		    }
		    System.out.append("Requested Json = " + postData + " ");
		    responseReader.close();
		    return new ModelAndView("/admin/viewTransactionStatus","responseJSON",responseData);
		} catch (Exception exception) {
		    exception.printStackTrace();
		    return new ModelAndView("redirect:/admin/transactionStatus");
		}
	}
}
