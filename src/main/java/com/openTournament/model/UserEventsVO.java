package com.openTournament.model;

import javax.persistence.*;

import com.openTournament.model.*;

@Entity

@Table(name="UserEvents")
public class UserEventsVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int userEventId;
	
	@ManyToOne
	UserProfileVO userProfileVO;
	
	@ManyToOne
	EventVO eventVO1;
	
	@Column
	private String paymentStatus;
	
	@Column
	private String attendance;
	
	@Column
	private String TeamName;
	
	@Column
	private String InstituteName;
	
	@Column
	private String CoachName;
	
	@Column
	private String CoachNumber;
	
	@Column
	private String teamMember01;
	
	@Column
	private String teamMember01_dob;
	
	@Column
	private String teamMember01_phonenumber;
	
	@Column
	private String teamMember1;
	
	@Column
	private String teamMember1_dob;
	
	@Column
	private String teamMember1_phonenumber;
	
	@Column
	private String teamMember2;
	
	@Column
	private String teamMember2_dob;
	
	@Column
	private String teamMember2_phonenumber;
	
	@Column
	private String teamMember3;
	
	@Column
	private String teamMember3_dob;
	
	@Column
	private String teamMember3_phonenumber;
	
	@Column
	private String teamMember4;
	
	@Column
	private String teamMember4_dob;
	
	@Column
	private String teamMember4_phonenumber;
	
	@Column
	private String teamMember5;

	@Column
	private String teamMember5_dob;
	
	@Column
	private String teamMember5_phonenumber;
	
	@Column
	private String teamMember6;

	@Column
	private String teamMember6_dob;
	
	@Column
	private String teamMember6_phonenumber;
	
	@Column
	private String teamMember7;

	@Column
	private String teamMember7_dob;
	
	@Column
	private String teamMember7_phonenumber;
	
	@Column
	private String teamMember8;

	@Column
	private String teamMember8_dob;
	
	@Column
	private String teamMember8_phonenumber;
	
	@Column
	private String teamMember9;

	@Column
	private String teamMember9_dob;
	
	@Column
	private String teamMember9_phonenumber;
	
	@Column
	private String teamMember10;

	@Column
	private String teamMember10_dob;
	
	@Column
	private String teamMember10_phonenumber;
	
	@Column
	private String teamMember11;

	@Column
	private String teamMember11_dob;
	
	@Column
	private String teamMember11_phonenumber;
	
	
	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}

	public String getInstituteName() {
		return InstituteName;
	}

	public void setInstituteName(String instituteName) {
		InstituteName = instituteName;
	}

	public String getTeamMember01() {
		return teamMember01;
	}

	public void setTeamMember01(String teamMember01) {
		this.teamMember01 = teamMember01;
	}

	public String getTeamMember01_dob() {
		return teamMember01_dob;
	}

	public void setTeamMember01_dob(String teamMember01_dob) {
		this.teamMember01_dob = teamMember01_dob;
	}

	public String getTeamMember01_phonenumber() {
		return teamMember01_phonenumber;
	}

	public void setTeamMember01_phonenumber(String teamMember01_phonenumber) {
		this.teamMember01_phonenumber = teamMember01_phonenumber;
	}

	public String getTeamMember10() {
		return teamMember10;
	}

	public void setTeamMember10(String teamMember10) {
		this.teamMember10 = teamMember10;
	}

	public String getTeamMember10_dob() {
		return teamMember10_dob;
	}

	public void setTeamMember10_dob(String teamMember10_dob) {
		this.teamMember10_dob = teamMember10_dob;
	}

	public String getTeamMember10_phonenumber() {
		return teamMember10_phonenumber;
	}

	public void setTeamMember10_phonenumber(String teamMember10_phonenumber) {
		this.teamMember10_phonenumber = teamMember10_phonenumber;
	}

	public String getTeamMember11() {
		return teamMember11;
	}

	public void setTeamMember11(String teamMember11) {
		this.teamMember11 = teamMember11;
	}

	public String getTeamMember11_dob() {
		return teamMember11_dob;
	}

	public void setTeamMember11_dob(String teamMember11_dob) {
		this.teamMember11_dob = teamMember11_dob;
	}

	public String getTeamMember11_phonenumber() {
		return teamMember11_phonenumber;
	}

	public void setTeamMember11_phonenumber(String teamMember11_phonenumber) {
		this.teamMember11_phonenumber = teamMember11_phonenumber;
	}

	public String getCoachName() {
		return CoachName;
	}

	public void setCoachName(String coachName) {
		CoachName = coachName;
	}

	public String getCoachNumber() {
		return CoachNumber;
	}

	public void setCoachNumber(String coachNumber) {
		CoachNumber = coachNumber;
	}

	public String getTeamMember1_phonenumber() {
		return teamMember1_phonenumber;
	}

	public void setTeamMember1_phonenumber(String teamMember1_phonenumber) {
		this.teamMember1_phonenumber = teamMember1_phonenumber;
	}

	public String getTeamMember2_phonenumber() {
		return teamMember2_phonenumber;
	}

	public void setTeamMember2_phonenumber(String teamMember2_phonenumber) {
		this.teamMember2_phonenumber = teamMember2_phonenumber;
	}

	public String getTeamMember3_phonenumber() {
		return teamMember3_phonenumber;
	}

	public void setTeamMember3_phonenumber(String teamMember3_phonenumber) {
		this.teamMember3_phonenumber = teamMember3_phonenumber;
	}

	public String getTeamMember4_phonenumber() {
		return teamMember4_phonenumber;
	}

	public void setTeamMember4_phonenumber(String teamMember4_phonenumber) {
		this.teamMember4_phonenumber = teamMember4_phonenumber;
	}

	public String getTeamMember5_phonenumber() {
		return teamMember5_phonenumber;
	}

	public void setTeamMember5_phonenumber(String teamMember5_phonenumber) {
		this.teamMember5_phonenumber = teamMember5_phonenumber;
	}

	public int getUserEventId() {
		return userEventId;
	}

	public String getTeamMember1_dob() {
		return teamMember1_dob;
	}

	public void setTeamMember1_dob(String teamMember1_dob) {
		this.teamMember1_dob = teamMember1_dob;
	}

	public String getTeamMember2_dob() {
		return teamMember2_dob;
	}

	public void setTeamMember2_dob(String teamMember2_dob) {
		this.teamMember2_dob = teamMember2_dob;
	}

	public String getTeamMember3_dob() {
		return teamMember3_dob;
	}

	public void setTeamMember3_dob(String teamMember3_dob) {
		this.teamMember3_dob = teamMember3_dob;
	}

	public String getTeamMember4_dob() {
		return teamMember4_dob;
	}

	public void setTeamMember4_dob(String teamMember4_dob) {
		this.teamMember4_dob = teamMember4_dob;
	}

	public String getTeamMember5_dob() {
		return teamMember5_dob;
	}

	public void setTeamMember5_dob(String teamMember5_dob) {
		this.teamMember5_dob = teamMember5_dob;
	}

	public void setUserEventId(int userEventId) {
		this.userEventId = userEventId;
	}

	public UserProfileVO getUserProfileVO() {
		return userProfileVO;
	}

	public void setUserProfileVO(UserProfileVO userProfileVO) {
		this.userProfileVO = userProfileVO;
	}

	public EventVO getEventVO1() {
		return eventVO1;
	}

	public void setEventVO1(EventVO eventVO1) {
		this.eventVO1 = eventVO1;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getAttendance() {
		return attendance;
	}

	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	public String getTeamMember1() {
		return teamMember1;
	}

	public void setTeamMember1(String teamMember1) {
		this.teamMember1 = teamMember1;
	}

	public String getTeamMember2() {
		return teamMember2;
	}

	
	public void setTeamMember2(String teamMember2) {
		this.teamMember2 = teamMember2;
	}

	public String getTeamMember3() {
		return teamMember3;
	}

	public void setTeamMember3(String teamMember3) {
		this.teamMember3 = teamMember3;
	}

	public String getTeamMember4() {
		return teamMember4;
	}

	public void setTeamMember4(String teamMember4) {
		this.teamMember4 = teamMember4;
	}

	public String getTeamMember5() {
		return teamMember5;
	}

	public void setTeamMember5(String teamMember5) {
		this.teamMember5 = teamMember5;
	}

	public String getTeamMember6() {
		return teamMember6;
	}

	public void setTeamMember6(String teamMember6) {
		this.teamMember6 = teamMember6;
	}

	public String getTeamMember6_dob() {
		return teamMember6_dob;
	}

	public void setTeamMember6_dob(String teamMember6_dob) {
		this.teamMember6_dob = teamMember6_dob;
	}

	public String getTeamMember6_phonenumber() {
		return teamMember6_phonenumber;
	}

	public void setTeamMember6_phonenumber(String teamMember6_phonenumber) {
		this.teamMember6_phonenumber = teamMember6_phonenumber;
	}

	public String getTeamMember7() {
		return teamMember7;
	}

	public void setTeamMember7(String teamMember7) {
		this.teamMember7 = teamMember7;
	}

	public String getTeamMember7_dob() {
		return teamMember7_dob;
	}

	public void setTeamMember7_dob(String teamMember7_dob) {
		this.teamMember7_dob = teamMember7_dob;
	}

	public String getTeamMember7_phonenumber() {
		return teamMember7_phonenumber;
	}

	public void setTeamMember7_phonenumber(String teamMember7_phonenumber) {
		this.teamMember7_phonenumber = teamMember7_phonenumber;
	}

	public String getTeamMember8() {
		return teamMember8;
	}

	public void setTeamMember8(String teamMember8) {
		this.teamMember8 = teamMember8;
	}

	public String getTeamMember8_dob() {
		return teamMember8_dob;
	}

	public void setTeamMember8_dob(String teamMember8_dob) {
		this.teamMember8_dob = teamMember8_dob;
	}

	public String getTeamMember8_phonenumber() {
		return teamMember8_phonenumber;
	}

	public void setTeamMember8_phonenumber(String teamMember8_phonenumber) {
		this.teamMember8_phonenumber = teamMember8_phonenumber;
	}

	public String getTeamMember9() {
		return teamMember9;
	}

	public void setTeamMember9(String teamMember9) {
		this.teamMember9 = teamMember9;
	}

	public String getTeamMember9_dob() {
		return teamMember9_dob;
	}

	public void setTeamMember9_dob(String teamMember9_dob) {
		this.teamMember9_dob = teamMember9_dob;
	}

	public String getTeamMember9_phonenumber() {
		return teamMember9_phonenumber;
	}

	public void setTeamMember9_phonenumber(String teamMember9_phonenumber) {
		this.teamMember9_phonenumber = teamMember9_phonenumber;
	}
}
