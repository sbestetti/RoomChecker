package ie.distilled.bizops.roomchecker.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

@Named
@RequestScoped
public class IndexBean{
	
	private String roomToCheck = new String();
	private String dateToCheck = new String();	
	
	//Methods
	public String check() {
		if(roomToCheck == null || dateToCheck.isEmpty()) {
			return "index?faces-redirect=true";
		} else {
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("room", roomToCheck);
			flash.put("date", dateToCheck);
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