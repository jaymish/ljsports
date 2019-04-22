package com.openTournament.model;

import javax.persistence.*;

import com.openTournament.model.*;

@Entity

@Table(name="userProfile")

public class UserProfileVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int profileId;
	
	@ManyToOne
	RegVO regVO;
	
	@Column
	private String City;
	
	/*
	 * @Column private String TeamName;
	 * 
	 * @ManyToOne InstituteVO instituteVO;
	 */
	
	@Column
	private String contact;
	
	@Column
	private String uniqueQR;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	public RegVO getRegVO() {
		return regVO;
	}

	public void setRegVO(RegVO regVO) {
		this.regVO = regVO;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	/*
	 * public String getTeamName() { return TeamName; }
	 * 
	 * public void setTeamName(String teamName) { TeamName = teamName; }
	 * 
	 * public InstituteVO getInstituteVO() { return instituteVO; }
	 * 
	 * public void setInstituteVO(InstituteVO instituteVO) { this.instituteVO =
	 * instituteVO; }
	 */

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getUniqueQR() {
		return uniqueQR;
	}

	public void setUniqueQR(String uniqueQR) {
		this.uniqueQR = uniqueQR;
	}
}
