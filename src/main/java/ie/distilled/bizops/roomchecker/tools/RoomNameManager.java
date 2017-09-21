package ie.distilled.bizops.roomchecker.tools;

public class RoomNameManager {
	
	public static String getResourceName(String roomLabel) {
		
		String resourceName = new String();
		
		switch (roomLabel) {
			case "brittas":
				resourceName = "distilled.ie_2d3535343537353130@resource.calendar.google.com";
				break;
			case "bull":
				resourceName = "distilled.ie_2d3235333336363236323437@resource.calendar.google.com";
				break;
			case "cape":
				resourceName = "distilled.ie_3735313434313434393930@resource.calendar.google.com";
				break;
			case "carl":
				resourceName = "distilled.ie_2d3137303831303732353833@resource.calendar.google.com";
				break;
			case "conn":
				resourceName = "distilled.ie_2d34313939353135373333@resource.calendar.google.com";
				break;
			case "dingle":
				resourceName = "distilled.ie_2d38313039363136373834@resource.calendar.google.com";
				break;
			case "doolin":
				resourceName = "distilled.ie_2d3236303330373037373238@resource.calendar.google.com";
				break;
			case "glen":
				resourceName = "distilled.ie_2d3537353832373730393238@resource.calendar.google.com";
				break;
			case "kill":
				resourceName = "distilled.ie_3736333330393738393731@resource.calendar.google.com";
				break;
			case "lach":
				resourceName = "distilled.ie_2d3338363732303138323431@resource.calendar.google.com";
				break;
			case "new":
				resourceName = "distilled.ie_2d3238313131333331313136@resource.calendar.google.com";
				break;
			case "liber":
				resourceName = "distilled.ie_2d38353734373831393931@resource.calendar.google.com";
				break;
			case "tramore":
				resourceName = "distilled.ie_2d32333231393139323538@resource.calendar.google.com";
				break;
			case "after":
				resourceName = "distilled.ie_2d34343636383630322d353334@resource.calendar.google.com";
				break;
			case "bdeal":
				resourceName = "distilled.ie_31343531333235322d323639@resource.calendar.google.com";
				break;
			case "bideas":
				resourceName = "distilled.ie_2d3632383532303635323233@resource.calendar.google.com";
				break;
			case "camper":
				resourceName = "distilled.ie_33373739373036312d363134@resource.calendar.google.com";
				break;
			case "cow":
				resourceName = "distilled.ie_3939353638373235313733@resource.calendar.google.com";
				break;
			case "disco":
				resourceName = "distilled.ie_2d35353133363731353836@resource.calendar.google.com";
				break;
			case "little":
				resourceName = "distilled.ie_36363933303438392d373733@resource.calendar.google.com";
				break;
			case "ndeal":
				resourceName = "distilled.ie_33383033313634363934@resource.calendar.google.com";
				break;
			default:
				resourceName = null;
				break;
		}
		
		return resourceName;
		
	}

}