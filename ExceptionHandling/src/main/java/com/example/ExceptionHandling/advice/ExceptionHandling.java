package com.example.ExceptionHandling.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.ExceptionHandling.service.UsernotFoundException;

@RestControllerAdvice
public class ExceptionHandling {
	@ExceptionHandler(UsernotFoundException.class)
	public String usernotfound(UsernotFoundException e) {
		return e.getMessage();
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> arginvalidException(MethodArgumentNotValidException e){
		Map<String,String> errormap=new HashMap<>();
		e.getBindingResult().getFieldErrors().
				forEach(error->{
					errormap.put(error.getField(),error.getDefaultMessage());
				});
		return errormap;
	}
}
