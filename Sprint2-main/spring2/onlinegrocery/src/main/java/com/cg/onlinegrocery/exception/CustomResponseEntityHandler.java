package com.cg.onlinegrocery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
	@RestController
	public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
		@ExceptionHandler
		public ResponseEntity<Object> handleTrackingStatusException(TrackingStatusException ex, WebRequest request){
			TrackingStatusExceptionResponse trackingStatusExceptionResponse =  new TrackingStatusExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(trackingStatusExceptionResponse,HttpStatus.BAD_REQUEST);
		}	
		
		@ExceptionHandler
		public ResponseEntity<Object> handleTrackingStatusNotFoundException(TrackingStatusNotFoundException ex, WebRequest request){
			TrackingStatusNotFoundExceptionResponse trackingStatusNotFoundExceptionResponse =  new TrackingStatusNotFoundExceptionResponse(ex.getMessage());
			return new ResponseEntity<Object>(trackingStatusNotFoundExceptionResponse,HttpStatus.BAD_REQUEST);
		}
		
	}