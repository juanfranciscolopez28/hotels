package com.hotels.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.hotels.dto.HotelDTO;

public class Hotel implements Serializable {
	
	private static final long serialVersionUID = 6242628769668870023L;
	
	private Long id;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private String name;
	private Integer rooms;
	private Long locationId;

	public Hotel() { }

	public Hotel(HotelDTO hotelDTO, Location location) {
		this.id = hotelDTO.getId();
		this.name = hotelDTO.getName();
		this.rooms = hotelDTO.getRooms();
		this.locationId = location.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

}