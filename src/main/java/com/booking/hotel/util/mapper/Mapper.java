package com.booking.hotel.util.mapper;

import java.util.ArrayList;
import java.util.List;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.projections.BookingProjection;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.persistence.transfer.HotelDto;

/**
 * 
 * @author juveme88
 *
 */
public class Mapper {

	private Mapper() {

	}

	public static List<BookingDto> lstProjectionBooking(List<BookingProjection> bookingResult) {
		List<BookingDto> response = new ArrayList<>();

		bookingResult.forEach(booking -> {
			BookingDto dto = new BookingDto();
			HotelDto hotelDto = new HotelDto();
			hotelDto.setId(booking.getIdHotel());
			hotelDto.setName(booking.getHotelName());
			dto.setEndDate(booking.getEndDate());
			dto.setNumberPeople(booking.getNumberPeople());
			dto.setId(booking.getId());
			dto.setStartDate(booking.getStartDate());
			dto.setHotel(hotelDto);
			response.add(dto);
		});
		return response;
	}

	public static BookingDto modelBookingToDto(BookingEntity entity, HotelDto hotelDto) {
		BookingDto dto = new BookingDto();
		dto.setId(entity.getId());
		dto.setNumberPeople(entity.getNumberPeople());
		dto.setEndDate(entity.getEndDate());
		dto.setStartDate(entity.getStartDate());
		dto.setHotel(hotelDto);
		return dto;
	}

	public static HotelDto modelHotelToDto(HotelEntity hotelFound) {
		HotelDto dto = new HotelDto();
		dto.setId(hotelFound.getId());
		dto.setName(hotelFound.getName());
		return dto;
	}

	public static HotelEntity modelHotelEntityToModel(HotelEntity entity) {
		HotelEntity model = new HotelEntity();
		model.setId(entity.getId());
		model.setName(entity.getName());
		model.setAddress(entity.getAddress());
		model.setDescription(entity.getDescription());
		model.setNit(entity.getNit());
		model.setStars(entity.getStars());
		return model;
	}
}
