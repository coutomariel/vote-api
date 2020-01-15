package com.coutomariel.vote.service.exception;

public class InvalidVoteException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidVoteException(String message) {
		super(message);
	}
	
	public InvalidVoteException(String message, Throwable cause) {
		super(message, cause);
	}

}
