package com.booking.hotel.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.booking.hotel.persistence.transfer.ResponseHotelData;
import com.booking.hotel.util.MessagesUtilEnum;

/**
 * 
 * @author juveme88
 *
 */
@RestControllerAdvice
public class RestExceptionHandler {

	@ResponseBody
	@ExceptionHandler({ Exception.class })
	public ResponseHotelData exceptionHandler(Exception ex, WebRequest request) {
		if (ex instanceof BussinessException) {
			BussinessException exception = (BussinessException) ex;
			return new ResponseHotelData(UUID.randomUUID().toString(), buildStatus(exception.getCode()),
					exception.getMessage(), null, null, 0L);
		}

		return new ResponseHotelData(UUID.randomUUID().toString(), HttpStatus.INTERNAL_SERVER_ERROR,
				MessagesUtilEnum.SERVER_ERROR.getMessage(), null, null, 0L);

	}

	private HttpStatus buildStatus(int status) {
		return HttpStatus.valueOf(status);
	}

}
