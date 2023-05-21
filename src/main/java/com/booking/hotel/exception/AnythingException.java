package com.booking.hotel.exception;

import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
public class AnythingException extends RuntimeException {

	private static final long serialVersionUID = 2474305095420686135L;

	private final int code;

	private final String message;

	public AnythingException(int code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public AnythingException(int code, String message, Throwable throwable) {
		super(message, throwable);
		this.code = code;
		this.message = message;
	}

}
