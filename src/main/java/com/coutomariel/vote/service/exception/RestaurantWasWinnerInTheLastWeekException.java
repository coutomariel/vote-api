package com.coutomariel.vote.service.exception;

public class RestaurantWasWinnerInTheLastWeekException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RestaurantWasWinnerInTheLastWeekException(String message) {
		super(message);
	}
	
	public RestaurantWasWinnerInTheLastWeekException(String message, Throwable cause) {
		super(message, cause);
	}

	
	
}
