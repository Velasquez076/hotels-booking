package com.booking.hotel.controller.impl;

import static com.booking.hotel.controller.constants.ControllerHotelConstants.BOOKING_RESOURCES;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.controller.intermediate.BookingControllerIntermediate;
import com.booking.hotel.persistence.transfer.BookingRequest;
import com.booking.hotel.persistence.transfer.ResponseBookingData;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@RestController
@RequestMapping(path = BOOKING_RESOURCES)
@RequiredArgsConstructor
public class BookingControllerImpl {

	private final BookingControllerIntermediate intermediate;

	/**
	 * 
	 * @param entity
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseBookingData saveBooking(@RequestBody BookingRequest entity) {
		return intermediate.saveBooking(entity.getBooking());
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseBookingData findAllBooking() {
		return intermediate.findAllBooking();
	}

}
