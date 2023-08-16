package com.booking.hotel.persistence.transfer.error;

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
public class ResponseError {

	private HttpStatus status;
	
	private String message;
}
