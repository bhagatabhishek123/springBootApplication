package com.abhinandan.payload;

public class ResponsePayload {

	private Object object;
	private String message;
	private int statuscode;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}

	public ResponsePayload(Object object, String message, int statuscode) {
		this.object = object;
		this.message = message;
		this.statuscode = statuscode;
	}

}
