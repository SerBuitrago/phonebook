package com.phonebook.util.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class PhonebookException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;

	
	public PhonebookException(String message) {
		this(HttpStatus.NOT_FOUND, message);
	}
	
	public PhonebookException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}
	
}
