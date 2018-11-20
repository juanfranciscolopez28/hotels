package com.hotels.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hotels.dto.ErrorDTO;

@ControllerAdvice
public class ErrorController {
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorDTO> notFoundException(final EmptyResultDataAccessException e) {
		
		ErrorDTO error = new ErrorDTO();
		error.setMessage("El registro no existe.");
		error.setInternalMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDTO> notFoundException(final IllegalArgumentException e) {
		
		ErrorDTO error = new ErrorDTO();
		error.setMessage("Error en los datos de entrada.");
		error.setInternalMessage(e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}