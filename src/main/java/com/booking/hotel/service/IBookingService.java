package com.booking.hotel.service;

import java.util.List;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;

/**
 * 
 * @author juveme88
 *
 */
public interface IBookingService {

	public List<BookingDto> findAllBooking();

	public BookingDto createBooking(BookingEntity entity);
}
