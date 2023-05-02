package com.booking.hotel.persistence.transfer;

import java.time.LocalDate;

import com.booking.hotel.persistence.entity.BookingEntity;

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
