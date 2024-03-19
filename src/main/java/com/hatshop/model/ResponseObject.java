package com.hatshop.model;

import org.springframework.http.HttpStatus;

public class ResponseObject {
	private HttpStatus httpStatus;
	private Object object;
	public ResponseObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseObject(HttpStatus httpStatus, Object object) {
		super();
		this.httpStatus = httpStatus;
		this.object = object;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
}
