<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<%=request.getContextPath() %>/adminResources/images/favicon.ico">

<title>Notion User - Team Selection</title>

<!-- Bootstrap 4.0-->
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/bootstrap.css"> --%>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- Bootstrap extend-->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/bootstrap-extend.css">

<!-- theme style -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/master_style.css">

<!-- skins -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/adminResources/css/_all-skins.css">

<script>
	function loadinputs(num)
	{
		var i=0;
		i=parseInt(num.value)
		var l=5
		while(l>0)
		{
			var inputs=document.getElementById("member"+l)
			inputs.style.display="none"
			l--
		}
		for(var k=1;k<=i;k++)
		{
			var inputs=document.getElementById("member"+k)
			
			inputs.style.display=""
		}
	}
	function confirmation()
	{
		var txt;
		var r = confirm("Are you sure all details are correct?");
		if (r == true) {
		  txt = "You pressed OK!";
		} else {
		  txt = "You pressed Cancel!";
		}
	}
</script>
</head>
<body class="hold-transition skin-light light-sidebar sidebar-mini">
	<div class="wrapper">

		<header class="main-header">
			<jsp:include page="header.jsp" />
		</header>
		
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar">
			<!-- sidebar-->
			<section class="sidebar">
				<jsp:include page="userMenu.jsp" />
			</section>
		</aside>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="container">
				<!-- Content Header (Page header) -->
				<div class="content-header">
					<div class="d-flex align-items-center">
						<div class="mr-auto">
							<h3 class="page-title">Team Members</h3>
							<div class="d-inline-block align-items-center">
								<nav>
									<ol class="breadcrumb">
										<li class="breadcrumb-item"><a href="Dashboard"><i
												class="mdi mdi-home-outline"></i></a></li>
										<li class="breadcrumb-item" aria-current="page">User</li>
										<li class="breadcrumb-item active" aria-current="page">Select Team</li>
									</ol>
								</nav>
							</div>
						</div>
					</div>
				</div>

				<!-- Main content -->
				<section class="content">

					<!-- Basic Forms -->
					<div class="box">
						<div class="box-header with-border">
							<h4 class="box-title">Enter Team Details</h4>
							<!-- <h6 class="box-subtitle">Bootstrap Form Validation check the <a class="text-warning" href="#">official website </a></h6> -->
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="row">
								<div class="col">
									<form:form novalidate="novalidate" action="insertTeamData"
										modelAttribute="selectTeamData" method="POST">
										<div class="row">
											<div class="col-12">
												<div class="form-group">
													<h5>
														Select No. of Members<span class="text-danger">*</span>
													</h5>
													<div class="controls">
														<select name="members" onchange="loadinputs(this)"
															class="form-control" required="required"
															data-validation-required-message="This field is required">
															<option>Select No.</option>
															<c:forEach begin="${minMembers}" end="${maxMembers}" var="i">
																<option value="${i}">${i}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												
												<div class="form-group" id="member1" style="display:none">
													<h5>Team Name</h5>
													<div class="controls">
														<form:input type="text" name="TeamName" path="TeamName" class="form-control"
														  required="required" placeholder="Enter Team Name"/>
													</div><br>
													<h5>Institute Name </h5>
													<div class="controls">
														<form:input type="text" name="InstituteName" path="InstituteName" class="form-control"
														 required="required" placeholder="Enter Institute Name" />
													</div><br>
													<h5>Name of Coach/Manager </h5>
													<div class="controls">
														<form:input type="text" name="CoachName" path="CoachName" class="form-control"
														 required="required" placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Phone Number of Coach/Manager</h5>
													<div class="controls">
														<form:input type="text" name="CoachNumber" path="CoachNumber" class="form-control"
														  required="required" placeholder="Enter Phone Number"/>
													</div><br>
													<h5>Name of Member 1 </h5>
													<div class="controls">
														<form:input type="text" name="member 1" path="teamMember01" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 1 dob" path="teamMember01_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 1 phonenumber" path="teamMember01_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member2" style="display:none">
													<h5>Name of Member 2 </h5>
													<div class="controls">
														<form:input type="text" name="member 2" path="teamMember1" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 2 dob" path="teamMember1_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 2 phonenumber" path="teamMember1_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member3" style="display:none">
													<h5>Name of Member 3 </h5>
													<div class="controls">
														<form:input type="text" name="member 3" path="teamMember2" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 3 dob" path="teamMember2_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 3 phonenumber" path="teamMember2_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member4" style="display:none">
													<h5>Name of Member 4 </h5>
													<div class="controls">
														<form:input type="text" name="member 4" path="teamMember3" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 4 dob" path="teamMember3_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 4 phonenumber" path="teamMember3_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member5" style="display:none">
													<h5>Name of Member 5 </h5>
													<div class="controls">
														<form:input type="text" name="member 5" path="teamMember4" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 5 dob" path="teamMember4_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 5 phonenumber" path="teamMember4_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member6" style="display:none">
													<h5>Name of Member 6 </h5>
													<div class="controls">
														<form:input type="text" name="member 6" path="teamMember5" class="form-control"
														 placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 6 dob" path="teamMember5_dob" class="form-control"/>
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 6 phonenumber" path="teamMember5_phonenumber" class="form-control"
														  placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member7" style="display:none">
													<h5>Name of Member 7 </h5>
													<div class="controls">
														<form:input type="text" name="member 6" path="teamMember6" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 7 dob" path="teamMember6_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 7 phonenumber" path="teamMember6_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member8" style="display:none">
													<h5>Name of Member 8 </h5>
													<div class="controls">
														<form:input type="text" name="member 8" path="teamMember7" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 8 dob" path="teamMember7_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 8 phonenumber" path="teamMember7_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member9" style="display:none">
													<h5>Name of Member 9 </h5>
													<div class="controls">
														<form:input type="text" name="member 9" path="teamMember8" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 9 dob" path="teamMember8_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 9 phonenumber" path="teamMember8_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member10" style="display:none">
													<h5>Name of Member 10 </h5>
													<div class="controls">
														<form:input type="text" name="member 10" path="teamMember9" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 10 dob" path="teamMember9_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 10 phonenumber" path="teamMember9_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member11" style="display:none">
													<h5>Name of Member 11 </h5>
													<div class="controls">
														<form:input type="text" name="member 11" path="teamMember10" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 11 dob" path="teamMember10_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 11 phonenumber" path="teamMember10_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
												<div class="form-group" id="member12" style="display:none">
													<h5>Name of Member 12 </h5>
													<div class="controls">
														<form:input type="text" name="member 12" path="teamMember11" class="form-control"
														placeholder="Enter Name(Firstname + Lastname)" />
													</div><br>
													<h5>Date of birth</h5>
													<div class="controls">
														<form:input type="date" name="member 12 dob" path="teamMember11_dob" class="form-control"
														 />
													</div><br>
													<h5>Phone Number</h5>
													<div class="controls">
														<form:input type="text" name="member 12 phonenumber" path="teamMember11_phonenumber" class="form-control"
														 placeholder="Enter Phone Number"/>
													</div>
												</div>
											</div>
										</div>
										<div class="text-xs-right">
											<button type="submit" id="subbtn" onclick="confirmation()" class="btn btn-info">Submit</button>
											<button type="reset" class="btn btn-info">Reset</button>
										</div>
									</form:form>
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->

				</section>
				<!-- /.content -->
			</div>
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<jsp:include page="footer.jsp" />
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<%-- <script src="<%=request.getContextPath() %>/adminResources/js/jquery-3.3.1.js"></script> --%>
	
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>

	<!-- Bootstrap 4.0-->
	<%-- <script src="<%=request.getContextPath() %>/adminResources/js/bootstrap.js"></script> --%>
	
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<!-- popper -->
	<%-- <script src="<%=request.getContextPath() %>/adminResources/js/popper.min.js"></script> --%>

	<!-- Slimscroll -->
	<script src="<%=request.getContextPath() %>/adminResources/js/jquery.slimscroll.js"></script>

	<!-- FastClick -->
	<script src="<%=request.getContextPath() %>/adminResources/js/fastclick.js"></script>

	<!-- UltimatePro Admin App -->
	<script src="<%=request.getContextPath() %>/adminResources/js/template.js"></script>

	<!-- UltimatePro Admin for demo purposes -->
	<script src="<%=request.getContextPath() %>/adminResources/js/demo.js"></script>

	<!-- Form validator JavaScript -->
	<script src="<%=request.getContextPath() %>/adminResources/js/validation.js"></script>
	<script src="<%=request.getContextPath() %>/adminResources/js/form-validation.js"></script>

</body>
</html>