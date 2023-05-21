package com.booking.hotel.persistence.transfer;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class ResponseBookingData<T> {

	private String uuid;

	private HttpStatus status;

	private String message;

	private T response;

	private Long size;

}
