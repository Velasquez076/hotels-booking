package com.booking.hotel.persistence.transfer;

import java.time.LocalDate;

import com.booking.hotel.persistence.entity.HotelEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@AllArgsConstructor
public class RequestHotel {

	private LocalDate createAt;
	
	@JsonProperty(value = "hotel")
	private HotelEntity entity;

}
