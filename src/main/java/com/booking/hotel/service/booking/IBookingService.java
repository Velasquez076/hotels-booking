package com.booking.hotel.service.booking;

import java.util.List;

import com.booking.hotel.persistence.entity.booking.BookingEntity;
import com.booking.hotel.persistence.transfer.booking.BookingDto;

/**
 * 
 * @author juveme88
 *
 */
public interface IBookingService {

	public List<BookingDto> findAllBooking();

	public BookingDto createBooking(BookingEntity entity);
}
