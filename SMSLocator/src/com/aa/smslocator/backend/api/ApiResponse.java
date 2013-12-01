package com.aa.smslocator.backend.api;

public class ApiResponse {
	private Status status;
	
	protected ApiResponse() {
	}
	public ApiResponse(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		if(status == null) return Status.MISSING;
		else return status;
	}
	
	public static ApiResponse status(Status status) {
		return new ApiResponse(status);
	}
	
	public static ApiResponse ok() {
		return new ApiResponse(Status.OK);
	}
	
	public static ApiResponse failed() {
		return new ApiResponse(Status.FAILED);
	}
	
	public enum Status {
		OK, FAILED, MISSING;
	}
}
