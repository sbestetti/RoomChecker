package ie.distilled.bizops.roomchecker.tools;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ie.distilled.bizops.roomchecker.models.Room;

@ApplicationScoped
public class RoomManager {	
	
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	public RoomManager() {
		try {
			JSONObject jsonObj = (JSONObject) new JSONParser()
					.parse(new FileReader("src/main/resources/rooms.json"));
			JSONArray array = (JSONArray) jsonObj.get("rooms");
			int counter = array.size();
			for (int i = 0; i < counter; i++) {
				JSONObject currentObj = (JSONObject) array.get(i);
				Room currentRoom = new Room();
				currentRoom.setName(currentObj.get("name").toString());
				currentRoom.setAddress((currentObj.get("address").toString()));
				// TODO Clear those IFs?
				if (currentObj.containsKey("capacity")) {
					currentRoom.setCapacity((long)currentObj.get("capacity"));
				}
				if (currentObj.containsKey("location")) {
					currentRoom.setLocation(currentObj.get("location").toString());
				}
				this.rooms.add(currentRoom);				
			}
		} catch (IOException | ParseException e) {
			// TODO Separate errors and write error message
			e.printStackTrace();
		}
	}
	
	public Room getRoomByAddress(String address) {
		for (Room room : this.getRoomList()) {
			if (room.getAddress().equals(address)) {
				return room;
			}
		}
		return null;
	}
	
	public ArrayList<Room> getRoomList() {
		return this.rooms;
	}	

}