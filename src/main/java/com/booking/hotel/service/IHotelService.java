package com.booking.hotel.service;

import java.util.List;

import com.booking.hotel.persistence.entity.HotelEntity;

/**
 * 
 * @author juveme88
 *
 */
public interface IHotelService {

	public List<HotelEntity> allHotels();

	public HotelEntity createHotel(HotelEntity entity);

	public HotelEntity findById(Long idHotel);

	public HotelEntity updateHotel(HotelEntity entity);
}
