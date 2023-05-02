package com.booking.hotel.controller.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.booking.hotel.controller.IBookingController;
import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.persistence.transfer.ResponseBookingData;
import com.booking.hotel.service.IBookingService;
import com.booking.hotel.util.MessagesUtilEnum;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Component
@RequiredArgsConstructor
public class BookingControllerIntermediate implements IBookingController {

	private final IBookingService bookingService;

	@Override
	public ResponseBookingData saveBooking(BookingEntity entity) {
		return new ResponseBookingData(UUID.randomUUID().toString(), HttpStatus.CREATED,
				MessagesUtilEnum.SAVE_HOTEL_SUCCESS.getMessage(), bookingService.createBooking(entity), new ArrayList<>(),
				1L);
	}

	@Override
	public ResponseBookingData findAllBooking() {
		List<BookingDto> lstResult = bookingService.findAllBooking();
		return new ResponseBookingData(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), null, lstResult, Long.valueOf(lstResult.size()));
	}

}
