package com.booking.hotel.controller.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.booking.hotel.controller.IHotelController;
import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.transfer.ResponseHotelData;
import com.booking.hotel.service.IHotelService;
import com.booking.hotel.util.MessagesUtilEnum;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Component
@RequiredArgsConstructor
public class HotelControllerIntermediate implements IHotelController {

	private final IHotelService hotelService;

	@Override
	public ResponseHotelData findAllHotels() {
		List<HotelEntity> response = hotelService.allHotels();
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), null, response, Long.valueOf(response.size()));
	}

	@Override
	public ResponseHotelData saveHotel(HotelEntity entity) {
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.CREATED,
				MessagesUtilEnum.SAVE_HOTEL_SUCCESS.getMessage(), hotelService.createHotel(entity), new ArrayList<>(), 1L);
	}

	@Override
	public ResponseHotelData findByIdHotel(Long hotelId) {
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.HOTELS_SUCCESS.getMessage(), hotelService.findById(hotelId), new ArrayList<>(), 1L);
	}

	@Override
	public ResponseHotelData updateHotel(HotelEntity entity) {
		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.OK,
				MessagesUtilEnum.UPDATED_HOTEL_SUCCESS.getMessage(), hotelService.updateHotel(entity), new ArrayList<>(),
				1L);
	}

}
