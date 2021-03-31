package com.cg.ofr.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;
import com.cg.ofr.exception.EntityNotFoundException;
import com.cg.ofr.exception.EntityUpdationException;

/************************************************************************************
 *          @author          B.Sai Kiran
 *          Description      It is a controller advice class that handles the exceptions
  *         Version             1.0
  *         Created Date    25-MARCH-2021
 ************************************************************************************/
@RestControllerAdvice
public class ControllerAdvice {

	/************************************************************************************
	 * Method:                          userNotFound
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                 It is parent class of exception
                *Created By                                - B.Sai Kiran
                *Created Date                            - 25-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler(EntityCreationException.class)
	public ResponseEntity<String> entityCreation(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/************************************************************************************
	 * Method:                          userNotFound
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                 It is parent class of exception
                *Created By                                - B.Sai Kiran
                *Created Date                            - 25-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler(EntityDeletionException.class)
	public ResponseEntity<String> entityDeletion(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/************************************************************************************
	 * Method:                          userNotFound
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                 It is parent class of exception
                *Created By                                - B.Sai Kiran
                *Created Date                            - 25-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> entityNotFound(RuntimeException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/************************************************************************************
	 * Method:                          userNotFound
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                 It is parent class of exception
                *Created By                                - B.Sai Kiran
                *Created Date                            - 25-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler(EmptyEntityListException.class)
	public ResponseEntity<String> emptyEntityList(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/************************************************************************************
	 * Method:                          userNotFound
     *Description:                      It is used to return the exception message and its HTTP status
	 * @returns Response entity         It returns the exception message and its HTTP status.
	 * @param exception                 It is parent class of exception
                *Created By                                - B.Sai Kiran
                *Created Date                            - 25-MARCH-2021                           
	 
	 ************************************************************************************/
	@ExceptionHandler(EntityUpdationException.class)
	public ResponseEntity<String> entityUpdation(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
