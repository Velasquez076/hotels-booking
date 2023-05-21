package com.booking.hotel.controller.impl;

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

import com.booking.hotel.controller.intermediate.BookingControllerIntermediate;
import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.transfer.BookingDto;
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
		
		when(intermediate.saveBooking(any(BookingEntity.class))).thenReturn(MocksBookingUtil.buildObjectResponse());
		
		
		@SuppressWarnings("unchecked")
		ResponseBookingData<BookingDto> result = bookingImpl.saveBooking(MocksBookingUtil.buildRequest());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		verify(intermediate, atLeastOnce()).saveBooking(any(BookingEntity.class));
		
	}

	@Test
	void findAllBookingTest() {
		when(intermediate.findAllBooking()).thenReturn(MocksBookingUtil.buildResponse());
		
		@SuppressWarnings("unchecked")
		ResponseBookingData<List<BookingDto>> result = bookingImpl.findAllBooking();
		
		assertNotNull(result);
		assertNotNull(result.getResponse());
		verify(intermediate, atLeastOnce()).findAllBooking();
		
	}
}
