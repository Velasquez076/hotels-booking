package com.booking.hotel.controller.intermediate;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.persistence.entity.hotel.HotelEntity;
import com.booking.hotel.persistence.transfer.hotel.ResponseHotelData;
import com.booking.hotel.service.hotel.IHotelService;
import com.booking.hotel.util.MocksHotelUtil;

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
		when(hotelService.allHotels()).thenReturn(MocksHotelUtil.buildList());
		ResponseHotelData<List<HotelEntity>> result = intermediate.findAllHotels();
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
	}

	@Test
	void saveHotelTest() {
		when(hotelService.createHotel(any(HotelEntity.class))).thenReturn(MocksHotelUtil.buildEntity());
		ResponseHotelData<HotelEntity> result = intermediate.saveHotel(MocksHotelUtil.buildEntity());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		verify(hotelService, atLeastOnce()).createHotel(any(HotelEntity.class));
	}

	@Test
	void findByIdHotelTest() {
		when(hotelService.findById(anyLong())).thenReturn(MocksHotelUtil.buildEntity());
		ResponseHotelData<HotelEntity> result = intermediate.findByIdHotel(1L);
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
	}

	@Test
	void updateHotelTest() {
		when(hotelService.updateHotel(any(HotelEntity.class))).thenReturn(MocksHotelUtil.buildEntity());
		
		ResponseHotelData<HotelEntity> result = intermediate.updateHotel(MocksHotelUtil.buildEntity());
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
	}
}
