package ie.distilled.bizops.roomchecker.models;

public class SimplifiedEvent {
	
	private String startTime;
	private String endTime;
	private String organizer;
	
	public SimplifiedEvent(String start, String end, String org) {
		this.startTime = start;
		this.endTime = end;
		this.organizer = org;
	}
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	
}
