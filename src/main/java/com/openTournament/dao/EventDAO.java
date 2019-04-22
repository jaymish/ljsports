package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.EventVO;
import com.openTournament.model.UserEventsVO;

public interface EventDAO {
	public void insertEvent(EventVO eventVO);
	public List<EventVO> viewEvents();
	public List<EventVO> editEvent(EventVO eventVO1);
	public void changeEventStatus(EventVO eventVO3);
	public void deleteEvent(EventVO eventVO4);
	public List<EventVO> unselectedEvents(UserEventsVO userEventsVO);
}
