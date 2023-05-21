package com.booking.hotel.controller.intermediate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.persistence.transfer.ResponseBookingData;
import com.booking.hotel.service.IBookingService;
import com.booking.hotel.util.MocksBookingUtil;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class BookingControllerIntermediateTest {

	@Mock
	IBookingService bookingService;

	@InjectMocks
	BookingControllerIntermediate controllerIntermediate;

	@Test
	void saveBookingTest() {
	
		when(bookingService.createBooking(any(BookingEntity.class))).thenReturn(MocksBookingUtil.buildDto());
		
		ResponseBookingData<BookingDto> result = controllerIntermediate.saveBooking(MocksBookingUtil.buildEntity());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		verify(bookingService, atLeastOnce()).createBooking(any(BookingEntity.class));
	}

	@Test
	void findAllBookingTest() {
		when(bookingService.findAllBooking()).thenReturn(MocksBookingUtil.buildListDto());
		
		ResponseBookingData<List<BookingDto>> result = controllerIntermediate.findAllBooking();
		
		assertNotNull(result);
		verify(bookingService).findAllBooking();
	}
}
