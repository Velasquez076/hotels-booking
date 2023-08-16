package com.booking.hotel.controller;

import java.util.List;

import com.booking.hotel.persistence.entity.booking.BookingEntity;
import com.booking.hotel.persistence.transfer.booking.BookingDto;
import com.booking.hotel.persistence.transfer.booking.ResponseBookingData;

/**
 * 
 * @author juveme88
 *
 */
public interface IBookingController {

	ResponseBookingData<BookingDto> saveBooking(BookingEntity entity);

	ResponseBookingData<List<BookingDto>> findAllBooking();

}
