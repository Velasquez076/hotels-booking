package com.booking.hotel.controller.intermediate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.transfer.ResponseHotelData;
import com.booking.hotel.service.IHotelService;
import com.booking.hotel.util.MocksUtil;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class HotelControllerIntermediateTest {

	@Mock
	IHotelService hotelService;

	@InjectMocks
	HotelControllerIntermediate intermediate;

	@Test
	void findAllHotelsTest() {
		when(hotelService.allHotels()).thenReturn(MocksUtil.buildList());
		ResponseHotelData result = intermediate.findAllHotels();
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
	}

	@Test
	void saveHotelTest() {
		when(hotelService.createHotel(any(HotelEntity.class))).thenReturn(MocksUtil.buildEntity());
		ResponseHotelData result = intermediate.saveHotel(MocksUtil.buildEntity());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
	}
}
