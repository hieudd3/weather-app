package com.oddle.app.weather.advice;

import com.oddle.app.weather.exception.WeatherAppException;
import com.oddle.app.weather.glossary.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class WeatherAppExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(WeatherAppExceptionHandler.class);

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		if (ex instanceof HttpRequestMethodNotSupportedException) {
			return new ResponseEntity<>(ErrorCode.METHOD_NOT_ALLOWED,
					HttpStatus.valueOf(ErrorCode.METHOD_NOT_ALLOWED.getStatus()));
		} else {
			log.error("Fail to process " + ((ServletWebRequest) request).getRequest().getRequestURI(), ex);
			return new ResponseEntity<>(ErrorCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ExceptionHandler({ WeatherAppException.class })
	public ResponseEntity<Object> handleApplicationException(WeatherAppException ex, WebRequest request) {
		return new ResponseEntity<>(ex.getErrorCode(), HttpStatus.valueOf(ex.getErrorCode().getStatus()));
	}

}
