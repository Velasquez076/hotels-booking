package com.booking.hotel.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author juveme88
 *
 */
@Setter
@Getter
@Entity
@Table(name = "tbl_booking", schema = "hotel_db")
public class BookingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOOKING")
	private Long id;

	@Column(name = "BOOKING_START_DATE")
	private LocalDate startDate;

	@Column(name = "BOOKING_END_DATE")
	private LocalDate endDate;

	@Column(name = "BOOKING_NUMBER_PEOPLE")
	private Long numberPeople;

	@Column(name = "BOOKING_HOTEL")
	private Long idHotel;
}
