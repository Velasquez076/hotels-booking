package com.booking.hotel.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.exception.BussinessException;
import com.booking.hotel.persistence.entity.BookingEntity;
import com.booking.hotel.persistence.repository.BookingRepository;
import com.booking.hotel.persistence.repository.HotelRepository;
import com.booking.hotel.persistence.transfer.BookingDto;
import com.booking.hotel.util.MocksBookingUtil;
import com.booking.hotel.util.MocksHotelUtil;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class BookingServiceImplTest {

	@Mock
	BookingRepository bookingRepository;

	@Mock
	HotelRepository hotelRepository;

	@InjectMocks
	BookingServiceImpl bookingServiceImpl;

	@Test
	void findAllBookingIsEmptyTest() {
		when(bookingRepository.findAllBooking()).thenReturn(new ArrayList<>());
		
		List<BookingDto> listResult = bookingServiceImpl.findAllBooking();
		assertTrue(listResult.isEmpty());
		verify(bookingRepository, atLeastOnce()).findAllBooking();
	}

	@Test
	void findAllBookingSuccessTest() {
		when(bookingRepository.findAllBooking()).thenReturn(new ArrayList<>());
		
		List<BookingDto> listResult = bookingServiceImpl.findAllBooking();
		assertTrue(listResult.isEmpty());
		verify(bookingRepository, atLeastOnce()).findAllBooking();
	}

	@Test
	void createBookingTest() {
		when(hotelRepository.findById(anyLong())).thenReturn(Optional.of(MocksHotelUtil.buildEntity()));
		
		when(bookingRepository.save(any(BookingEntity.class))).thenReturn(MocksBookingUtil.buildEntity());
		
		BookingDto result = bookingServiceImpl.createBooking(MocksBookingUtil.buildEntity());
		
		assertNotNull(result);
		verify(bookingRepository, atLeastOnce()).save(any(BookingEntity.class));
	}

	@Test
    void createBookingThrowsExceptionTest() {
        when(hotelRepository.findById(MocksBookingUtil.buildEntity().getIdHotel())).thenReturn(Optional.empty());
        
        BookingEntity entity = MocksBookingUtil.buildEntity();
        assertThrows(BussinessException.class, () -> bookingServiceImpl.createBooking(entity));
        
        verify(hotelRepository, atLeastOnce()).findById(anyLong());
    }
}
