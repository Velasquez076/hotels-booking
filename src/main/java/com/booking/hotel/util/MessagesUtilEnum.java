package com.booking.hotel.util;

import lombok.Getter;

/**
 * 
 * @author juveme88
 *
 */
public enum MessagesUtilEnum {

	HOTELS_SUCCESS(".:: Query successfully! ::."), 
	SAVE_HOTEL_SUCCESS(".:: Save Successfully! ::."),
	UPDATED_HOTEL_SUCCESS(".:: Updated Successfully! ::."),
	NOT_FOUND(".:: Resource not found.. ::."),
	ALREDY_EXIST_HOTEL(".:: Hotel already exists! ::."),
	SERVER_ERROR("An unexpected error has occurred, contact your administrator!");

	@Getter
	private String message;

	private MessagesUtilEnum(String message) {
		this.message = message;
	}
}
