package com.booking.hotel.util;

import java.time.LocalDate;

import com.booking.hotel.persistence.projections.BookingProjection;

import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Setter
public class BuildBookingProjection implements BookingProjection {

	private Long id;

	private LocalDate startDate;

	private LocalDate endDate;

	private Long numberPeople;

	private Long idHotel;

	private String hotelName;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public LocalDate getStartDate() {
		return this.startDate;
	}

	@Override
	public LocalDate getEndDate() {
		return this.endDate;
	}

	@Override
	public Long getNumberPeople() {
		return this.numberPeople;
	}

	@Override
	public Long getIdHotel() {
		return this.idHotel;
	}

	@Override
	public String getHotelName() {
		return this.hotelName;
	}

}
