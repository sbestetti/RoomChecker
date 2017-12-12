package ie.distilled.bizops.roomchecker.tools;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RoomListReader {
	
	private JSONParser parser = new JSONParser();
	
	public void readFile() {
		
		try {
			Object obj = parser.parse(new FileReader("src/main/resources/rooms.json"));
			JSONObject jsonObj = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObj.get("rooms");
			int counter = array.size();
			for (int i = 0; i < counter; i++) {
				JSONObject currentObj = (JSONObject) array.get(i);
				System.out.println(currentObj);
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
