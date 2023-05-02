package com.booking.hotel.controller;

import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.transfer.ResponseHotelData;

/**
 * 
 * @author juveme88
 *
 */
public interface IHotelController {

	ResponseHotelData findAllHotels();

	ResponseHotelData saveHotel(HotelEntity entity);

	ResponseHotelData findByIdHotel(Long hotelId);

	ResponseHotelData updateHotel(HotelEntity entoty);
}
