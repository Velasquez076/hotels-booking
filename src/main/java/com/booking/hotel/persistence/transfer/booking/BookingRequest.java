package com.booking.hotel.persistence.transfer.booking;

import java.time.LocalDate;

import com.booking.hotel.persistence.entity.booking.BookingEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class BookingRequest {

	private LocalDate createAt;
	
	private BookingEntity booking;
}
