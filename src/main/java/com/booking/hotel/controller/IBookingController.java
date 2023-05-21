package com.booking.hotel.controller;

import java.util.List;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.persistence.transfer.ResponseBookingData;

/**
 * 
 * @author juveme88
 *
 */
public interface IBookingController {

	ResponseBookingData<BookingDto> saveBooking(BookingEntity entity);

	ResponseBookingData<List<BookingDto>> findAllBooking();

}
