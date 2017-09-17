package ie.distilled.bizops.roomchecker.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean {
	
	private String roomToCheck = new String();
	private String dateToCheck = new String();
	
	//Methods
	public void check() {
		System.out.println("Check for " + this.roomToCheck + " on " + this.dateToCheck);
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
