package com.booking.hotel.controller.impl;

import static com.booking.hotel.controller.constants.ControllerHotelConstants.HOTEL_BY_ID;
import static com.booking.hotel.controller.constants.ControllerHotelConstants.HOTEL_ID;
import static com.booking.hotel.controller.constants.ControllerHotelConstants.HOTEL_RESOURCES;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.controller.intermediate.HotelControllerIntermediate;
import com.booking.hotel.persistence.entity.HotelEntity;
import com.booking.hotel.persistence.transfer.RequestHotel;
import com.booking.hotel.persistence.transfer.ResponseHotelData;

import lombok.RequiredArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@RestController
@RequestMapping(path = HOTEL_RESOURCES)
@RequiredArgsConstructor
class HotelControllerImpl {

	private final HotelControllerIntermediate intermediate;

	/**
	 * @return ResponseData
	 */
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseHotelData<List<HotelEntity>> findAllHotels() {
		return intermediate.findAllHotels();
	}

	/**
	 * 
	 * @param dto
	 * @return
	 */
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseHotelData<HotelEntity> saveHotel(@RequestBody RequestHotel dto) {
		return intermediate.saveHotel(dto.getEntity());
	}

	/**
	 * 
	 * @param hotelId
	 * @return
	 */
	@GetMapping(path = HOTEL_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseHotelData<HotelEntity> findByIdHotel(@RequestHeader(name = HOTEL_ID, required = true) Long hotelId) {
		return intermediate.findByIdHotel(hotelId);
	}

	/**
	 * 
	 * @param hotel
	 * @return
	 */
	@PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseHotelData<HotelEntity> updateHotel(@RequestBody RequestHotel hotel) {
		return intermediate.updateHotel(hotel.getEntity());
	}

}
