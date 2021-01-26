package com.helical.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -8083340296881714005L;

	public NotFoundException(String message) {
		super(message);
	}

}

