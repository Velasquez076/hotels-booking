package com.booking.hotel.service.hotel.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.booking.hotel.exception.AnythingException;
import com.booking.hotel.persistence.entity.hotel.HotelEntity;
import com.booking.hotel.persistence.repository.hotel.HotelRepository;
import com.booking.hotel.service.hotel.IHotelService;
import com.booking.hotel.util.MessagesUtilEnum;
import com.booking.hotel.util.mapper.Mapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author juveme88
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService {

	private final HotelRepository hotelRepository;

	@Override
	public List<HotelEntity> allHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public HotelEntity createHotel(HotelEntity entity) {
		HotelEntity foundHotel = hotelRepository.findByNit(entity.getNit()).orElse(null);
		if (foundHotel != null) {
			log.info(".:: Hotel exist already ::.");
			throw new AnythingException(HttpStatus.OK.value(), MessagesUtilEnum.ALREDY_EXIST_HOTEL.getMessage());
		}
		return hotelRepository.save(entity);
	}

	@Override
	public HotelEntity findById(Long idHotel) {
		HotelEntity response = hotelRepository.findById(idHotel).orElse(null);
		if (response != null) {
			return response;
		}
		throw new AnythingException(HttpStatus.NOT_FOUND.value(), MessagesUtilEnum.NOT_FOUND.getMessage());
	}

	@Override
	public HotelEntity updateHotel(HotelEntity entity) {
		HotelEntity foundHotel = hotelRepository.findById(entity.getId()).orElse(null);
		if (foundHotel != null) {
			return hotelRepository.save(Mapper.modelHotelEntityToModel(entity));
		}
		throw new AnythingException(HttpStatus.NOT_FOUND.value(), MessagesUtilEnum.NOT_FOUND.getMessage());
	}

}
