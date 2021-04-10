package com.oddle.app.weather.glossary;

import static javax.servlet.http.HttpServletResponse.*;

public class ErrorCode {
	public static ErrorCode METHOD_NOT_ALLOWED = new ErrorCode(SC_METHOD_NOT_ALLOWED, "METHOD_NOT_ALLOWED",
			"Method not allow");
	public static ErrorCode RESOURCE_NOT_FOUND = new ErrorCode(SC_NOT_FOUND, "RESOURCE_NOT_FOUND",
			"Resource not found");
	public static ErrorCode FORBIDDEN = new ErrorCode(SC_FORBIDDEN, "FORBIDDEN", "Input invalid");
	public static ErrorCode INTERNAL_SERVER_ERROR = new ErrorCode(SC_INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR",
			"INTERNAL_SERVER_ERROR");

	private int status;
	private String code;
	private String message;

	ErrorCode(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public ErrorCode setStatus(int status) {
		this.status = status;
		return this;
	}

	public String getCode() {
		return code;
	}

	public ErrorCode setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

}
