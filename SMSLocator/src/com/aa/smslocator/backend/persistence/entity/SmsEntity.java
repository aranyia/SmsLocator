package com.aa.smslocator.backend.persistence.entity;

import com.aa.smslocator.backend.resource.Location;
import com.aa.smslocator.backend.resource.SmsMessage;
import com.aa.smslocator.backend.resource.SmsResource;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Serialize;

@Cache(expirationSeconds=600)
@Entity
public class SmsEntity extends DataEntity {
	String message; 
	@Index String source;
	@Index String receiver;
	
	@Serialize
	Location location;

	protected SmsEntity() {
	}
	public SmsEntity(SmsResource smsRes) {
		this.setResource(smsRes);
	}

	public void setResource(SmsResource smsRes) {
		if(smsRes == null) return;
		final SmsMessage smsMsg = smsRes.getMessage();
		if(smsMsg == null) return;
		message = smsMsg.getMessage();
		source = smsMsg.getSource();
		receiver = smsMsg.getReceiver();
		
		final Location smsLoc = smsRes.getLocation();
		location = smsLoc;
	}

	public SmsResource getResource() {
		final SmsResource smsRes = new SmsResource(getMessageEntity());
		smsRes.setLocation(location);
		smsRes.setId(id);
		
		return smsRes;
	}

	private SmsMessage getMessageEntity() {
		return new SmsMessage(message, source, receiver);
	}

	public static SmsEntity wrap(SmsResource smsRes) {
		return new SmsEntity(smsRes);
	}
}
