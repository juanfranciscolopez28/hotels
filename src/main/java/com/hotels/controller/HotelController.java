package com.hotels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotels.dto.HotelDTO;
import com.hotels.service.HotelService;

@RestController
@RequestMapping(value = "/hotels", produces = { MediaType.APPLICATION_JSON_VALUE })
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<HotelDTO> selectAll() {
		return hotelService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public HotelDTO index(@PathVariable("id") Long id) {
		return hotelService.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public boolean insert(@RequestBody HotelDTO hotelDTO) {
		return hotelService.insert(hotelDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		hotelService.deleteById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id") Long id, @RequestBody HotelDTO hotel) {
		hotelService.update(hotel, id);
	}
}
