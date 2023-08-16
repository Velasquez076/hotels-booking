package com.booking.hotel.controller;

import java.util.List;

import com.booking.hotel.persistence.entity.hotel.HotelEntity;
import com.booking.hotel.persistence.transfer.hotel.ResponseHotelData;

/**
 * 
 * @author juveme88
 *
 */
public interface IHotelController {

	ResponseHotelData<List<HotelEntity>> findAllHotels();

	ResponseHotelData<HotelEntity> saveHotel(HotelEntity entity);

	ResponseHotelData<HotelEntity> findByIdHotel(Long hotelId);

	ResponseHotelData<HotelEntity> updateHotel(HotelEntity entoty);
}
