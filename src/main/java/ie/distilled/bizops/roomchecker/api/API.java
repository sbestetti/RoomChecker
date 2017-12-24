package ie.distilled.bizops.roomchecker.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.api.services.calendar.model.Event;

import ie.distilled.bizops.roomchecker.models.SimplifiedEvent;
import ie.distilled.bizops.roomchecker.tools.GoogleAPI;

@Path("/api")
public class API {
	
	@GET
	@Path("/events")
	@Produces("application/json")
	public List<SimplifiedEvent> getEvents() {
		
		List<Event> events = GoogleAPI.getEvents("distilled.ie_3735313434313434393930@resource.calendar.google.com", "2017-12-12");
		List<SimplifiedEvent> response = new ArrayList<>();
		
		for (Event e : events) {
			try {
				response.add(new SimplifiedEvent(e.getStart().toPrettyString(), e.getEnd().toPrettyString(), e.getOrganizer().getEmail()));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		return response;
		
	}

}
