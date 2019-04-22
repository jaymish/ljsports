package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.InstituteVO;

public interface InstituteDAO {
	public void insertInstitute(InstituteVO instituteVO);
	public List<InstituteVO> viewInstitutes();
	public List<InstituteVO> editInstitute(InstituteVO instituteVO1);
	public void updateInstitute(InstituteVO instituteVO2);
	public void deleteInstitute(InstituteVO instituteVO3);
}
