package com.hotels.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hotels.model.Location;

@Repository
public class LocationDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	class LocationRowMapper implements RowMapper<Location> {
		@Override
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			Location location = new Location();
			location.setId(rs.getLong("id"));
			location.setCode(rs.getString("code"));
			location.setName(rs.getString("name"));
			
			return location;
		}

	}

	/**
	 * Obtiene una localización a partir de la primary key
	 * @param id
	 * @return
	 */
	public Location findById(Long id) {
		return jdbcTemplate.queryForObject("select * from location where id=?", new Object[] { id }, new LocationRowMapper());
	}
	
	/**
	 * Obtiene una locaclización a partir del código
	 * @param code
	 * @return
	 */
	public Location findByCode(String code) {
		return jdbcTemplate.queryForObject("select * from location where code=?", new Object[] { code }, new LocationRowMapper());
	}

}