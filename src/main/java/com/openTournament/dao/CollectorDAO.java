package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.CollectorVO;

public interface CollectorDAO {
	public void insertCollection(CollectorVO collectorVO);
	public List<CollectorVO> viewCollection();
}
