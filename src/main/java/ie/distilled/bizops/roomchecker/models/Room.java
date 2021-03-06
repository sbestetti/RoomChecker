package ie.distilled.bizops.roomchecker.models;

public class Room {
	
	private String name;
	private String address;
	private String location;
	private Long capacity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getCapacity() {
		return capacity;
	}
	public void setCapacity(long l) {
		this.capacity = l;
	}	

}