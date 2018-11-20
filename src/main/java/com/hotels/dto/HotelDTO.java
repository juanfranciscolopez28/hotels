package com.hotels.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.hotels.model.Hotel;
import com.hotels.model.Location;

public class HotelDTO implements Serializable {

	private static final long serialVersionUID = 8064837071462472336L;
	
	private Long id;
	
	@NotNull
	private String name;
	private Integer rooms;
	private LocationDTO location;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	
	public HotelDTO() {
		super();
	}

	public HotelDTO(Hotel hotel, Location location) {
		super();
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.rooms = hotel.getRooms();
		this.createDate = hotel.getCreateDate();
		this.updateDate = hotel.getUpdateDate();
		this.location = new LocationDTO(location);
	}

	public HotelDTO(Hotel hotel) {
		super();
		this.id = hotel.getId();
		this.name = hotel.getName();
		this.rooms = hotel.getRooms();
		this.createDate = hotel.getCreateDate();
		this.updateDate = hotel.getUpdateDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocationDTO getLocation() {
		return location;
	}

	public void setLocation(LocationDTO location) {
		this.location = location;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
