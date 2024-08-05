package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(value=AgeNotAcceptableException.class)
	public ResponseEntity<ExceptionInfo> AgeException(AgeNotAcceptableException ex){
		ExceptionInfo exInfo = new ExceptionInfo();
		exInfo.setCode("AI238");
		exInfo.setMsg(ex.getMessage());
		return new ResponseEntity<>(exInfo,HttpStatus.BAD_REQUEST);
		
	}

}
