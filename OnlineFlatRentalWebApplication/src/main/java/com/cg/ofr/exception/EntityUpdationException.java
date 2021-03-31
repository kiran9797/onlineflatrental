package com.cg.ofr.exception;

/************************************************************************************
 * @author          Y.Manideep
 * Description      It is a exception class that handles the exception occurs at 
 *                  service level
 * Version          1.0
 * Created Date     24-MARCH-2021
 ************************************************************************************/
public class EntityUpdationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityUpdationException(String message) {
		super(message);
	}

}
