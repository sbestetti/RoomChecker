package ie.distilled.bizops.roomchecker.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.api.services.calendar.model.Event;

import ie.distilled.bizops.roomchecker.tools.GoogleAPI;
import ie.distilled.bizops.roomchecker.tools.RoomManager;

@Named
@ConversationScoped
public class EventsBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8673816951488187213L;

	@Inject
	RoomManager roomManager;
	
	private List<Event> events = new ArrayList<>();	
	
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
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	private void getDataFromIndexBean() {
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		if (flash != null) {
			ArrayList<String> rooms = (ArrayList<String>) flash.get("rooms");
			ArrayList<Event> events = new ArrayList<>();
			String date = (String) flash.get("date");
			for (String room : rooms) {
				events.addAll(GoogleAPI.getEvents(room, date));
			}			
			this.setEvents(events);
		}
	}
	
	//Getters & Setters
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}	
	
}