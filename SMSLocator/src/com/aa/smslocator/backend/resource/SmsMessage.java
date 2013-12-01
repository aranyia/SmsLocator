package com.aa.smslocator.backend.resource;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Embed;

@Embed
public class SmsMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String source, receiver, message;
	private Date time;

	protected SmsMessage() {
	}
	public SmsMessage(String source, String receiver, String message) {
		setSource(source);
		setReceiver(receiver);
		setMessage(message);
	}
	public SmsMessage(String sender, String receiver, String message, Date time) {
		this(sender, receiver, message);
		setTime(time);
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
