package com.productservice.productservice.dtos;

import org.springframework.http.HttpStatus;

public class ExceptionDto {
	private HttpStatus httpStatus;
	private String message;
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpMethod) {
		this.httpStatus = httpMethod;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
