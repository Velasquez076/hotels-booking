package com.booking.hotel.persistence.transfer.hotel;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHotelData<T> {

	private String uuid;

	private HttpStatus status;

	private String message;

	private T response;

	private Long size;

}
