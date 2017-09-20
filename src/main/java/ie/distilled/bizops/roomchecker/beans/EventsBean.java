package ie.distilled.bizops.roomchecker.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import com.google.api.services.calendar.model.Event;

import ie.distilled.bizops.roomchecker.tools.GoogleAPI;

@Named
public class EventsBean{
	
	private List<Event> events = new ArrayList<>();
	
	@PostConstruct
	private void getDataFromIndexBean() {
		setEvents(GoogleAPI.getEvents());
	}

	//Getters & Setters
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}	
	
}