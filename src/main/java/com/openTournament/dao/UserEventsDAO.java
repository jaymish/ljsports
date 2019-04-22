package com.openTournament.dao;

import java.util.List;

import com.openTournament.model.UserEventsVO;
import com.openTournament.model.UserProfileVO;

public interface UserEventsDAO {
	public void insertUserEvent(UserEventsVO userEventsVO);
	public List<UserEventsVO> viewUserEvents(UserEventsVO userEventsVO1);
	public void removeUserEvent(UserEventsVO userEventsVO3);
	public List<UserEventsVO> paymentComplete();
	public List<UserEventsVO> paymentPending();
	public void collectPayment(UserProfileVO userProfileVO);
	public List<UserEventsVO> viewPresence();
	public int markAttendance(UserEventsVO userEventsVO2);
}
