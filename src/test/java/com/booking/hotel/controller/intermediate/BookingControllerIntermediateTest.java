package com.booking.hotel.controller.intermediate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.persistence.entity.BookingEntity;
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
		
		ResponseBookingData result = controllerIntermediate.saveBooking(MocksBookingUtil.buildEntity());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		assertTrue(result.getLstElemList().isEmpty());
		verify(bookingService, atLeastOnce()).createBooking(any(BookingEntity.class));
	}

	@Test
	void findAllBookingTest() {
		when(bookingService.findAllBooking()).thenReturn(MocksBookingUtil.buildListDto());
		
		ResponseBookingData result = controllerIntermediate.findAllBooking();
		
		assertNotNull(result);
		assertFalse(result.getLstElemList().isEmpty());
		verify(bookingService).findAllBooking();
	}
}
