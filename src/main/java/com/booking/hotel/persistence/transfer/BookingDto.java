package com.booking.hotel.persistence.transfer;

import java.time.LocalDate;

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
