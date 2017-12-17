package ie.distilled.bizops.roomchecker.converters;

import java.util.ArrayList;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import ie.distilled.bizops.roomchecker.models.Room;
import ie.distilled.bizops.roomchecker.tools.RoomManager;

@FacesConverter("RoomConverter")
public class RoomConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		new RoomManager();
		ArrayList<Room> rooms = RoomManager.getRoomList();
		for (Room room : rooms) {
			if (room.getAddress().equals(arg2)) {
				return room;
			}
		}		
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}

}
