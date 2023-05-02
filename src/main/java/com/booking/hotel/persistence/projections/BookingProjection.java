package com.booking.hotel.persistence.projections;

import java.time.LocalDate;

/**
 * 
 * @author juveme88
 *
 */
public interface BookingProjection {

	Long getId();

	LocalDate getStartDate();

	LocalDate getEndDate();

	Long getNumberPeople();

	Long getIdHotel();

	String getHotelName();
}
