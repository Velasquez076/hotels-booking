package com.booking.hotel.persistence.transfer.booking;

import java.time.LocalDate;

import com.booking.hotel.persistence.transfer.hotel.HotelDto;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Setter
@Getter
public class BookingDto {
	
	private Long id;

	private LocalDate startDate;
	
	private LocalDate endDate;

	private Long numberPeople;
	
	private HotelDto hotel;

}
