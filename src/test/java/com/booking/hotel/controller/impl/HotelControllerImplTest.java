package com.booking.hotel.controller.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
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

		ResponseHotelData<List<HotelEntity>> result = controllerImpl.findAllHotels();
		
		assertNotNull(result);
		assertEquals(200, result.getStatus().value());
	}

	@Test
	void saveHotelTest() {
		when(intermediate.saveHotel(any(HotelEntity.class))).thenReturn(buildObject());
	
		ResponseHotelData<HotelEntity> result = controllerImpl.saveHotel(buildRequest());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		verify(intermediate, atLeastOnce()).saveHotel(any(HotelEntity.class));
		
	}

	@Test
	void findByIdHotelTest() {
		when(intermediate.findByIdHotel(anyLong())).thenReturn(buildObject());

		ResponseHotelData<HotelEntity> result = controllerImpl.findByIdHotel(1L);
		
		assertNotNull(result);
	}

	@Test
	void updateHotelTest() {
		when(intermediate.updateHotel(any(HotelEntity.class))).thenReturn(buildObject());
		
		ResponseHotelData<HotelEntity> result = controllerImpl.updateHotel(buildRequest());
		
		assertNotNull(result);
		assertEquals(201, result.getStatus().value());
		verify(intermediate, atLeastOnce()).updateHotel(any(HotelEntity.class));
	}

	RequestHotel buildRequest() {
		return new RequestHotel(LocalDate.now(), MocksHotelUtil.buildEntity());
	}

	ResponseHotelData<List<HotelEntity>> buildList() {
		return new ResponseHotelData<>(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), MocksHotelUtil.buildList(), 1L);
	}

	ResponseHotelData<HotelEntity> buildObject() {
		return new ResponseHotelData<>(UUID.randomUUID().toString(), HttpStatus.CREATED,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), MocksHotelUtil.buildEntity(), 1L);
	}

}
