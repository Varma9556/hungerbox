package com.hungerbox.exception;

public class FoodItemNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FoodItemNotFoundException(String message) {
		super(message);
	}

}
