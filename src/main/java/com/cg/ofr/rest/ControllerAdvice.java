package com.cg.ofr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.FlatBookingNotFoundException;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.exception.PaymentNotFoundException;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.exception.UserNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(EntityCreationException.class)
	public ResponseEntity<String> entityCreation(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityDeletionException.class)
	public ResponseEntity<String> entityDeletion(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FlatBookingNotFoundException.class)
	public ResponseEntity<String> FlatBookingNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(FlatNotFoundException.class)
	public ResponseEntity<String> FlatNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TenantNotFoundException.class)
	public ResponseEntity<String> TenantNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LandlordNotFoundException.class)
	public ResponseEntity<String> LandlordNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<String> entityNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> UserNotFound(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EmptyEntityListException.class)
	public ResponseEntity<String> emptyEntityList(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EntityUpdationException.class)
	public ResponseEntity<String> entityUpdation(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}