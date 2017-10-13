package ie.distilled.bizops.roomchecker.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class IndexBean implements Serializable{
	
	private static final long serialVersionUID = 3185526729050141711L;
	
	private String roomToCheck = new String();
	private String dateToCheck = new String();	
	
	//Methods
	public String check() {
		if(roomToCheck == null || dateToCheck.isEmpty()) {
			return "index?faces-redirect=true";
		} else {
			return "events?faces-redirect=true";
		}
	}
	
	public String freeRooms() {
		return "freerooms?faces-redirect=true";
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