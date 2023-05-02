package com.booking.hotel.controller;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.ResponseBookingData;

/**
 * 
 * @author juveme88
 *
 */
public interface IBookingController {
	
	ResponseBookingData saveBooking(BookingEntity entity);
	
	ResponseBookingData findAllBooking();
	
}
