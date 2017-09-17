package ie.distilled.bizops.roomchecker.beans;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class EventsBean{
	
	@Inject
	IndexBean indexBean;
	
	private String roomToCheck = new String();
	private String dateToCheck = new String();
	
	@PostConstruct
	private void getDataFromIndexBean() {
		this.roomToCheck = indexBean.getRoomToCheck();
		this.dateToCheck = indexBean.getDateToCheck();
	}

	//Getters & Setters
	public String getRoomToCheck() {
		return roomToCheck;
	}

	public void setRoomToCheck(String roomToCheck) {
		this.roomToCheck = roomToCheck;
	}

	public String getDateToCheck() {
		return dateToCheck;
	}

	public void setDateToCheck(String dateToCheck) {
		this.dateToCheck = dateToCheck;
	}	

}