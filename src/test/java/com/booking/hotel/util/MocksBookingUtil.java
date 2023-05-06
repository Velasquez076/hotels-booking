package com.booking.hotel.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.persistence.transfer.BookingRequest;
import com.booking.hotel.persistence.transfer.HotelDto;
import com.booking.hotel.persistence.transfer.ResponseBookingData;

/**
 * 
 * @author juveme88
 *
 */
public class MocksBookingUtil {

	private final static String MSJ = "GENERIC_MESSAGE";

	private MocksBookingUtil() {

	}

	public static BookingRequest buildRequest() {
		BookingRequest model = new BookingRequest(LocalDate.now(), new BookingEntity());
		return model;
	}

	public static ResponseBookingData buildResponse() {
		return new ResponseBookingData("1", HttpStatus.CREATED, MSJ, buildDto(), buildListDto(), 2L);
	}

	public static BookingDto buildDto() {
		BookingDto dto = new BookingDto();
		dto.setEndDate(LocalDate.now());
		dto.setHotel(new HotelDto());
		dto.setId(1L);
		dto.setNumberPeople(1L);
		dto.setStartDate(LocalDate.now());
		return dto;
	}

	public static List<BookingDto> buildListDto() {
		List<BookingDto> list = new ArrayList<>();
		list.add(buildDto());
		return list;
	}

	public static BookingEntity buildEntity() {
		BookingEntity model = new BookingEntity();
		model.setStartDate(LocalDate.now());
		model.setEndDate(LocalDate.now());
		model.setId(1L);
		model.setIdHotel(1L);
		model.setNumberPeople(2L);
		return model;
	}

	public static BookingEntity buildEntityNotFound() {
		BookingEntity model = new BookingEntity();
		model.setIdHotel(9999L);
		return model;
	}
}
