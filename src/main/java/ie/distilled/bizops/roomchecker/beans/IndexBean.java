package ie.distilled.bizops.roomchecker.beans;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import ie.distilled.bizops.roomchecker.models.Room;
import ie.distilled.bizops.roomchecker.tools.RoomManager;

@Named
@RequestScoped
public class IndexBean{	
	
	private ArrayList<String> roomsToCheck = new ArrayList<String>();
	private String dateToCheck = new String();
	private ArrayList<Room> rooms = new ArrayList<>();
	private Room room = new Room();
	
	//Methods
	
	public String check() {
		if(roomsToCheck == null || dateToCheck.isEmpty()) {			
			return "index?faces-redirect=true";
		} else {			
			Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
			flash.put("rooms", roomsToCheck);
			flash.put("date", dateToCheck);
			return "events?faces-redirect=true";
		}
	}
	
	public String freeRooms() {
		return "freerooms?faces-redirect=true";
	}

	//Getters & Setters
	public ArrayList<String> getRoomsToCheck() {
		return roomsToCheck;
	}

	public void setRoomsToCheck(ArrayList<String> roomToCheck) {		
		this.roomsToCheck = roomToCheck;
	}

	public String getDateToCheck() {
		return dateToCheck;
	}

	public void setDateToCheck(String dateToCheck) {
		this.dateToCheck = dateToCheck;
	}

	public ArrayList<Room> getRooms() {
		this.rooms = RoomManager.getRoomList();		
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}	

}