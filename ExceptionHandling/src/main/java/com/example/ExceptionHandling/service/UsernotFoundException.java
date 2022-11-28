package com.example.ExceptionHandling.service;

@SuppressWarnings("serial")
public class UsernotFoundException extends RuntimeException {
	UsernotFoundException(String message){
		super(message);
	}

}
