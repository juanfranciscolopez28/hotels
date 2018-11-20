package com.hotels.dto;

import java.io.Serializable;

import com.hotels.model.Location;

public class LocationDTO implements Serializable{

	private static final long serialVersionUID = -3044503295996973279L;
	
	private String code;
	private String name;

	public LocationDTO() {
		super();
	}

	public LocationDTO(Location location) {
		this.code = location.getCode();
		this.name = location.getName();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
