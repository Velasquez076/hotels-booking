package com.booking.hotel.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.booking.hotel.exception.BussinessException;
import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.projections.BookingProjection;
import com.booking.hotel.persistence.repository.BookingRepository;
import com.booking.hotel.persistence.repository.HotelRepository;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.service.IBookingService;
import com.booking.hotel.util.MessagesUtilEnum;
import com.booking.hotel.util.mapper.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements IBookingService {

	private final BookingRepository bookingRepository;

	private final HotelRepository hotelRepository;

	@Override
	public List<BookingDto> findAllBooking() {
		log.info(".:: init query all booking ::.");
		List<BookingProjection> bookingResult = bookingRepository.findAllBooking();
		if (!bookingResult.isEmpty()) {
			return Mapper.lstProjectionBooking(bookingResult);
		}
		return new ArrayList<>();
	}

	@Override
	public BookingDto createBooking(BookingEntity entity) {
		HotelEntity hotelFound = hotelRepository.findById(entity.getIdHotel()).orElse(null);
		if (hotelFound != null) {
			bookingRepository.save(entity);
			return Mapper.modelBookingToDto(entity, Mapper.modelHotelToDto(hotelFound));
		}
		throw new BussinessException(HttpStatus.BAD_REQUEST.value(), MessagesUtilEnum.NOT_FOUND.getMessage());
	}
}
