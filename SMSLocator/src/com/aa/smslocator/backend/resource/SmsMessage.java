package com.aa.smslocator.backend.resource;

import java.util.Date;

public class SmsMessage {
	private String source, receiver, message;
	private Date time;

	protected SmsMessage() {
	}
	public SmsMessage(String sender, String receiver) {
		
	}
	public SmsMessage(String sender, String receiver, String message) {
		this(sender, receiver);
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
