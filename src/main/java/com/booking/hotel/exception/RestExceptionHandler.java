package com.booking.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.booking.hotel.persistence.transfer.error.ResponseError;
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
	public ResponseError exceptionHandler(Exception ex, WebRequest request) {
		if (ex instanceof AnythingException) {
			AnythingException exception = (AnythingException) ex;
			return new ResponseError(buildStatus(exception.getCode()),exception.getMessage());
		}

		return new ResponseError(HttpStatus.INTERNAL_SERVER_ERROR, MessagesUtilEnum.SERVER_ERROR.getMessage());

	}

	private HttpStatus buildStatus(int status) {
		return HttpStatus.valueOf(status);
	}

}
