package com.hotels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hotels.model.Hotel;

@Repository
public class HotelDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	class HotelRowMapper implements RowMapper<Hotel> {
		@Override
		public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
			Hotel hotel = new Hotel();
			hotel.setId(rs.getLong("id"));
			hotel.setName(rs.getString("name"));
			hotel.setRooms(rs.getInt("rooms"));
			hotel.setLocationId(rs.getLong("location_id"));
			hotel.setCreateDate(rs.getTimestamp("create_date").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
			hotel.setUpdateDate(rs.getTimestamp("update_date") != null ? rs.getTimestamp("update_date").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null);
			return hotel;
		}

	}

	/**
	 * Obtiene todos los elementos de la tabla hotel
	 * @return
	 */
	public List<Hotel> findAll() {
		return jdbcTemplate.query("select * from hotel", new HotelRowMapper());
	}

	/**
	 * Obtiene un registro de hotel a partir de la primary key
	 * @param id
	 * @return
	 */
	public Hotel findById(Long id) {
		return jdbcTemplate.queryForObject("select * from hotel where id=?", new Object[] { id }, new HotelRowMapper());
	}

	/**
	 * Elimina un registro de hotel a partir de la primary key
	 * @param id
	 * @return
	 */
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from hotel where id=?", new Object[] { id });
	}

	/**
	 * Inserta un registro hotel
	 * @param hotel
	 * @return
	 */
	public int insert(Hotel hotel) {
		return jdbcTemplate.update("insert into hotel (name, rooms, location_id) " + "values(?, ?, ?)",
				new Object[] { hotel.getName(), hotel.getRooms(), hotel.getLocationId() });
	}

	/**
	 * Actualiza un registro hotel
	 * @param hotel
	 * @return
	 */
	public int update(Hotel hotel, Long id) {
		return jdbcTemplate.update("update hotel " + " set name = ?, rooms = ?, location_id = ?, update_date = ? " + " where id = ?",
				new Object[] { hotel.getName(), hotel.getRooms(), hotel.getLocationId(), LocalDateTime.now(), id });
	}

}