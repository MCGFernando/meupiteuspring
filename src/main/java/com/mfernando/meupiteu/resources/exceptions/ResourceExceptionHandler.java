package com.mfernando.meupiteu.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mfernando.meupiteu.services.exceptions.DataIntegrityException;
import com.mfernando.meupiteu.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // fornece um mecanismo para tratar exceções de forma global em toda a aplicação Spring MVC
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundException.class) // para tratar exceções específicas
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityException.class) // para tratar exceções específicas
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException ex, HttpServletRequest request){
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
