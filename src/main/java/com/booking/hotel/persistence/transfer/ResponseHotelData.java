package com.booking.hotel.persistence.transfer;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.booking.hotel.persistence.entity.HotelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 
 * @author juveme88
 *
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseHotelData {

	private String uuid;

	private HttpStatus status;

	private String message;

	@JsonInclude(value = Include.NON_NULL)
	private HotelEntity element;

	@JsonInclude(value = Include.NON_EMPTY)
	private List<HotelEntity> lstElemList;

	private Long size;

}
