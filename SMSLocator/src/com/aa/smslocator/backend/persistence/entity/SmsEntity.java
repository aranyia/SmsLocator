package com.aa.smslocator.backend.persistence.entity;

import java.util.Date;

import com.aa.smslocator.backend.resource.Location;
import com.aa.smslocator.backend.resource.SmsMessage;
import com.aa.smslocator.backend.resource.SmsResource;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Embed;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

@Cache(expirationSeconds=600)
@Entity
public class SmsEntity extends DataEntity {
	String message; 
	@Index String source;
	@Index String receiver;
	@Index Date time;
	LocationWrapper location;

	protected SmsEntity() {
	}
	public SmsEntity(SmsResource smsRes) {
		this.setResource(smsRes);
	}

	public void setResource(SmsResource smsRes) {
		if(smsRes == null) return;
		setMessageResource(smsRes.getMessage());
		location = LocationWrapper.wrap(smsRes.getLocation());
	}

	public void setMessageResource(SmsMessage smsMsg) {
		if(smsMsg == null) return;
		message = smsMsg.getMessage();
		source = smsMsg.getSource();
		receiver = smsMsg.getReceiver();
		time = smsMsg.getTime();
	}

	public SmsResource getResource() {
		final SmsResource smsRes = new SmsResource(getMessageResource());
		smsRes.setLocation(location.getResource());
		smsRes.setId(id);
		
		return smsRes;
	}

	private SmsMessage getMessageResource() {
		return new SmsMessage(source, receiver, message, time);
	}

	public static SmsEntity wrap(SmsResource smsRes) {
		return new SmsEntity(smsRes);
	}
	
	@Embed
	public static class LocationWrapper {
		protected float accuracy;
		protected double longitude, latitude;
		protected Date time;
		
		protected LocationWrapper() {
		}
		public LocationWrapper(Location location) {
			this.setResource(location);
		}
		
		public Location getResource() {
			final Location location = new Location(longitude, latitude);
			location.setAccuracy(accuracy);
			location.setTime(time);
			return location;
		}

		public void setResource(Location location) {
			accuracy = location.getAccuracy();
			latitude = location.getLatitude();
			longitude = location.getLongitude();
			time = location.getTime();
		}
		
		public static LocationWrapper wrap(Location location) {
			return new LocationWrapper(location);			
		}
	}
}
