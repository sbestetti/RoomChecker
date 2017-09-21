package ie.distilled.bizops.roomchecker.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.google.api.services.calendar.model.Event;

@FacesConverter("EventConverter")
public class EventConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		
		Event event = (Event) object;
		String response = new String();
		String start = event.getStart().getDateTime().toStringRfc3339().substring(11, 16);
		String end = event.getEnd().getDateTime().toStringRfc3339().substring(11, 16);
		if (event.getOrganizer().getDisplayName() != null) {
			response = "From " + start + " to " + end + " scheduled by " 
					+ event.getOrganizer().getDisplayName() + " (" + event.getOrganizer().getEmail() + ") "; 
		} else {
			response = "From " + start + " to " + end + " scheduled by "  + event.getOrganizer().getEmail();
		}
		
		return response;
		
	}

}