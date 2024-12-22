package com.sunbeam.ipl.custom_exceptions;

public class ApiException extends RuntimeException{

	public ApiException(String errMsg) {
		super(errMsg);
	}
	
}
