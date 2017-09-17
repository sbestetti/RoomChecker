package ie.distilled.bizops.roomchecker.beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.google.api.services.calendar.model.Event;

import ie.distilled.bizops.roomchecker.tools.GoogleAPI;

@Named
public class EventsBean{
	
	@Inject
	IndexBean indexBean;	
	
	private List<Event> events = new ArrayList<>();
	
	@PostConstruct
	private void getDataFromIndexBean() {
		try {
			setEvents(GoogleAPI.getItems(indexBean.getRoomToCheck(), indexBean.getDateToCheck()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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