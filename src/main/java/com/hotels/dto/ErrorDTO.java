package com.hotels.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {

	private static final long serialVersionUID = 6963750272825377508L;
	
	private String message;
	private String internalMessage;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInternalMessage() {
		return internalMessage;
	}
	public void setInternalMessage(String internalMessage) {
		this.internalMessage = internalMessage;
	}
	
	
}
