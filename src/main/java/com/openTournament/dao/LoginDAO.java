package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.LoginVO;

public interface LoginDAO {
	public void insertToLogin(LoginVO loginVO);
	public List<LoginVO> getUser(LoginVO loginVO1);
	public void verifyUser(LoginVO loginVO2);
	public void changeEnabled(LoginVO loginVO3);
	public void resetPassword(LoginVO loginVO4);
}
