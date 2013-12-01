package com.aa.smslocator.backend.resource;

public class SmsResource {
	private SmsMessage message;
	private Location location;
	private Long id;

	protected SmsResource() {
	}
	public SmsResource(SmsMessage message) {
		this.setMessage(message);
	}
	public SmsResource(SmsMessage message, Location location) {
		this(message);
		this.setLocation(location);
	}
	
	public SmsMessage getMessage() {
		return message;
	}
	public void setMessage(SmsMessage message) {
		this.message = message;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public long getId() {
		return id;
	}
	public boolean setId(long id) {
		if(this.id != null) return false;
		else {
			this.id = id;
			return true;
		}
	}
}
