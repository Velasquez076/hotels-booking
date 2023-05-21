package com.booking.hotel.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.booking.hotel.exception.AnythingException;
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
	HotelRepository hotelRepository;

	@InjectMocks
	HotelServiceImpl hotelImpl;

	@Test
	void allHotelsTest() {
		when(hotelRepository.findAll()).thenReturn(MocksHotelUtil.buildList());
		List<HotelEntity> result = hotelImpl.allHotels();
		
		assertFalse(result.isEmpty());
		verify(hotelRepository, atLeastOnce()).findAll();
	}

	@Test
	void createHotelSucessTest() {
		when(hotelRepository.save(any(HotelEntity.class))).thenReturn(MocksHotelUtil.buildEntity());
		HotelEntity result = hotelImpl.createHotel(MocksHotelUtil.buildEntity());
		
		assertNotNull(result);
		verify(hotelRepository, atLeastOnce()).save(any(HotelEntity.class));
	}

	@Test
	void createHotelExistTest() {
		when(hotelRepository.findByNit(anyString())).thenReturn(Optional.of(MocksHotelUtil.buildExistEntity()));
		try {
			hotelImpl.createHotel(MocksHotelUtil.buildExistEntity());
			fail(MessagesUtilEnum.ALREDY_EXIST_HOTEL.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Test
	void findByIdSuccessTest() {
		when(hotelRepository.findById(anyLong())).thenReturn(Optional.of(MocksHotelUtil.buildEntity()));
		HotelEntity result = hotelImpl.findById(1L);
		
		assertNotNull(result);
	}

	@Test
	void findByIdFailThrowsExceptionTest() {
		when(hotelRepository.findById(anyLong())).thenReturn(Optional.empty());
		
        assertThrows(AnythingException.class, () -> hotelImpl.findById(1L));
        
        verify(hotelRepository, atLeastOnce()).findById(anyLong());
	}

	@Test
	void updateHotelSuccessTest() {
		
		when(hotelRepository.findById(anyLong())).thenReturn(Optional.of(MocksHotelUtil.buildEntity()));
		
		when(hotelRepository.save(any(HotelEntity.class))).thenReturn(MocksHotelUtil.buildEntity());
		
		HotelEntity result = hotelImpl.updateHotel(MocksHotelUtil.buildEntity());
		
		assertNotNull(result);
	}

	@Test
	void updateHotelFailThrowsExceptionTest() {
		when(hotelRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		HotelEntity entity = MocksHotelUtil.buildEntity();
        assertThrows(AnythingException.class, () -> hotelImpl.updateHotel(entity));
        
        verify(hotelRepository, atLeastOnce()).findById(anyLong());
	}
}
