package com.booking.hotel.persistence.entity.hotel;

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
@Table(name = "tbl_hotel", schema = "hotel_db")
public class HotelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_HOTEL")
	private Long id;

	@Column(name = "HOTEL_NIT")
	private String nit;
	
	@Column(name = "HOTEL_NAME")
	private String name;

	@Column(name = "HOTEL_ADDRESS")
	private String address;

	@Column(name = "HOTEL_DESCRIPTION")
	private String description;

	@Column(name = "HOTEL_STARS")
	private Integer stars;
}
