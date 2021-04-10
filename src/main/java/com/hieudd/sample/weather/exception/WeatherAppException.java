package com.hieudd.sample.weather.exception;

import com.hieudd.sample.weather.glossary.ErrorCode;

public class WeatherAppException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ErrorCode errorCode;

    public WeatherAppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public WeatherAppException(ErrorCode errorCode, Throwable t) {
        super(t);
        this.errorCode = errorCode;
    }

    public WeatherAppException(ErrorCode errorCode, String message, Throwable t) {
        super(message, t);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
