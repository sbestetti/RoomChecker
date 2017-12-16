package ie.distilled.bizops.roomchecker.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Named;

import com.google.api.services.calendar.model.Event;

import ie.distilled.bizops.roomchecker.models.Room;
import ie.distilled.bizops.roomchecker.tools.GoogleAPI;

@Named
public class EventsBean{
	
	private List<Event> events = new ArrayList<>();
	private String roomNameBeautiful = new String();
	
//	@PostConstruct
//	private void getDataFromIndexBean() {
//		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
//		if (flash != null) {
//			String room = (String) flash.get("room");
//			String date = (String) flash.get("date");
//			String roomToCheck = room;
//			roomNameBeautiful = RoomNameManager.getResourceName(roomToCheck, false);
//			String resourceName = RoomNameManager.getResourceName(roomToCheck, true);
//			setEvents(GoogleAPI.getEvents(resourceName, date));
//		}
//	}
	
	@PostConstruct
	private void getDataFromIndexBean() {
		// TODO Clear messages
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		if (flash != null) {
			System.out.println(flash.get("room"));
			Room room = (Room) flash.get("room");
			String date = (String) flash.get("date");
			this.roomNameBeautiful = room.getName();
			this.setEvents(GoogleAPI.getEvents(room.getAddress(), date));
		} else {
			System.out.println("Flash context empty");
		}
	}
	
	//Getters & Setters
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public String getRoomNameBeautiful() {
		return roomNameBeautiful;
	}

	public void setRoomNameBeautiful(String roomNameBeautiful) {
		this.roomNameBeautiful = roomNameBeautiful;
	}	
	
}