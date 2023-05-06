package com.booking.hotel.persistence.transfer;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class ResponseBookingData {

	private String uuid;

	private HttpStatus status;

	private String message;

	@JsonInclude(value = Include.NON_NULL)
	private BookingDto element;

	@JsonInclude(value = Include.NON_EMPTY)
	private List<BookingDto> lstElemList;

	private Long size;

}
