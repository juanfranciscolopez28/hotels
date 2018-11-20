package com.hotels.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotels.dao.HotelDao;
import com.hotels.dao.LocationDao;
import com.hotels.dto.HotelDTO;
import com.hotels.model.Hotel;
import com.hotels.model.Location;

@Service
public class HotelService {

	@Autowired
	private HotelDao hotelDao;
	
	@Autowired
	private LocationDao locationDao;

	/**
	 * Devuelve todos los hoteles
	 * @return
	 */
	public List<HotelDTO> findAll() {
		
		List<HotelDTO> rs = new ArrayList<>();
		
		// Obtenemos todos los hoteles sin las localizaciones y lo convertimos a DTO
		List<Hotel> hotelList = hotelDao.findAll();
		hotelList.parallelStream().forEach(t -> rs.add(new HotelDTO(t)));
		
		return rs;
	}

	/**
	 * Busca un hotel a partir de la primary key
	 * @param id
	 * @return
	 */
	public HotelDTO findById(long id) {
		
		// Obtenemos los datos de hotel y localización.
		Hotel hotel = hotelDao.findById(id);
		Location location = locationDao.findById(hotel.getLocationId());
		
		// Generamos el DTO a partir de las entidades
		return new HotelDTO(hotel, location);
	}

	/**
	 * Elimina un hotel mediante la primary key
	 * @param id
	 * @return
	 */
	public boolean deleteById(long id) {
		
		// Comprobamos si el registro existe, si no existe se lanzara EmptyResultDataAccessException que se procesara en ErrorController
		hotelDao.findById(id);
		hotelDao.deleteById(id);
		
		return Boolean.TRUE;
	}

	/**
	 * Inserta un nuevo hotel
	 * @param hotelDTO
	 * @return
	 */
	public boolean insert(HotelDTO hotelDTO) {
		
		// Si no se ha informado el código de la localización lanzamos excepcion que procesara ErrorController
		if(hotelDTO.getLocation() == null || hotelDTO.getLocation().getCode() == null) {
			throw new IllegalArgumentException("El código de localización esta vacio.");
		}
		
		Location location = locationDao.findByCode(hotelDTO.getLocation().getCode());
		Hotel hotel = new Hotel(hotelDTO, location);
		
		hotelDao.insert(hotel);
		
		return Boolean.TRUE;
	}

	/**
	 * Modifica un hotel
	 * @param hotel
	 * @return
	 */
	public boolean update(HotelDTO hotelDTO, Long id) {

		// Si no se ha informado el código de la localización lanzamos excepcion que procesara ErrorController
		if(hotelDTO.getLocation() == null || hotelDTO.getLocation().getCode() == null) {
			throw new IllegalArgumentException("El código de localización esta vacio.");
		}
		
		hotelDao.findById(id);
		
		Location location = locationDao.findByCode(hotelDTO.getLocation().getCode());
		
		hotelDao.update(new Hotel(hotelDTO, location), id);

		return Boolean.TRUE;
	}

}