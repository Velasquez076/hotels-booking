package com.booking.hotel.controller.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.booking.hotel.controller.intermediate.HotelControllerIntermediate;
import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.transfer.RequestHotel;
import com.booking.hotel.persistence.transfer.ResponseHotelData;
import com.booking.hotel.util.MessagesUtilEnum;
import com.booking.hotel.util.MocksHotelUtil;

/**
 * 
 * @author juveme88
 *
 */
@ExtendWith(MockitoExtension.class)
class HotelControllerImplTest {

	@Mock
	HotelControllerIntermediate intermediate;

	@InjectMocks
	HotelControllerImpl controllerImpl;

	@Test
	void findAllHotels() {
		when(intermediate.findAllHotels()).thenReturn(buildList());
		ResponseHotelData result = controllerImpl.findAllHotels();
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
		assertFalse(result.getLstElemList().isEmpty());
	}

	@Test
	void saveHotelTest() {
		when(intermediate.saveHotel(any(HotelEntity.class))).thenReturn(buildObject());
		ResponseHotelData result = controllerImpl.saveHotel(buildRequest());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		assertTrue(result.getLstElemList().isEmpty());
		verify(intermediate, atLeastOnce()).saveHotel(any(HotelEntity.class));
		
	}

	RequestHotel buildRequest() {
		return new RequestHotel(LocalDate.now(), MocksHotelUtil.buildEntity());
	}

	ResponseHotelData buildList() {
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), null, MocksHotelUtil.buildList(), 1L);
	}

	ResponseHotelData buildObject() {
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.CREATED,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), MocksHotelUtil.buildEntity(), new ArrayList<>(), 1L);
	}

}
