package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.RegVO;

public interface RegDAO {
	
	public void insertToRegister(RegVO regVO);
	public List<RegVO> getRegDetails(RegVO regVO1);
	public List<RegVO> unverifiedUsers();
	/*public void updateProfileStatus(RegVO regVO2);*/
}
