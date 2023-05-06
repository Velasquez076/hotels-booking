package com.booking.hotel.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.repository.HotelRepository;
import com.booking.hotel.util.MessagesUtilEnum;
import com.booking.hotel.util.MocksHotelUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Slf4j
@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {

	@Mock
	HotelRepository hotelEntityRepository;

	@InjectMocks
	HotelServiceImpl hotelImpl;

	@Test
	void allHotelsTest() {
		when(hotelEntityRepository.findAll()).thenReturn(MocksHotelUtil.buildList());
		List<HotelEntity> result = hotelImpl.allHotels();
		
		assertFalse(result.isEmpty());
		verify(hotelEntityRepository, atLeastOnce()).findAll();
	}

	@Test
	void createHotelSucessTest() {
		when(hotelEntityRepository.save(any(HotelEntity.class))).thenReturn(MocksHotelUtil.buildEntity());
		HotelEntity result = hotelImpl.createHotel(MocksHotelUtil.buildEntity());
		
		assertNotNull(result);
		verify(hotelEntityRepository, atLeastOnce()).save(any(HotelEntity.class));
	}

	@Test
	void createHotelExistTest() {
		when(hotelEntityRepository.findByNit(anyString())).thenReturn(Optional.of(MocksHotelUtil.buildExistEntity()));
		try {
			hotelImpl.createHotel(MocksHotelUtil.buildExistEntity());
			fail(MessagesUtilEnum.ALREDY_EXIST_HOTEL.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Test
	void findByIdSuccessTest() {
		when(hotelEntityRepository.findById(anyLong())).thenReturn(Optional.of(MocksHotelUtil.buildEntity()));
		HotelEntity result = hotelImpl.findById(1L);
		
		assertNotNull(result);
	}
}
