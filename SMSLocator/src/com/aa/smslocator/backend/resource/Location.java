package com.aa.smslocator.backend.resource;

import java.util.Date;

public class Location {
	private float accuracy;
	private double longitude, latitude;
	private Date time;

	protected Location() {
	}
	public Location(double longitude, double latitude) {
		setLongitude(longitude);
		setLatitude(latitude);
	}

	public float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
