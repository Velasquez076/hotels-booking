package com.booking.hotel.controller.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

import com.booking.hotel.controller.intermediate.BookingControllerIntermediate;
import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.ResponseBookingData;
import com.booking.hotel.util.MocksBookingUtil;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class BookingControllerImplTest {

	@Mock
	BookingControllerIntermediate intermediate;

	@InjectMocks
	BookingControllerImpl bookingImpl;

	@Test
	void saveBookingTest() {
		
		when(intermediate.saveBooking(any(BookingEntity.class))).thenReturn(MocksBookingUtil.buildResponse());
		
		ResponseBookingData result = bookingImpl.saveBooking(MocksBookingUtil.buildRequest());
		
		assertNotNull(result);
		assertNotNull(result.getElement());
		assertFalse(result.getLstElemList().isEmpty());
		assertEquals(201, result.getStatus().value());
		verify(intermediate, atLeastOnce()).saveBooking(any(BookingEntity.class));
		
	}

	@Test
	void findAllBookingTest() {
		when(intermediate.findAllBooking()).thenReturn(MocksBookingUtil.buildResponse());
		
		ResponseBookingData result = bookingImpl.findAllBooking();
		
		assertNotNull(result);
		assertNotNull(result.getElement());
		assertFalse(result.getLstElemList().isEmpty());
		verify(intermediate, atLeastOnce()).findAllBooking();
		
	}
}
