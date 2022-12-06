package com.ind.indianTeam.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ind.indianTeam.exception.PlayerAlreadyPresentException;
import com.ind.indianTeam.exception.PlayerNotFoundException;

@RestControllerAdvice
public class BaseController {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidException(MethodArgumentNotValidException ex){
		Map<String, String> exResponse=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e->{
			exResponse.put(e.getField(), e.getDefaultMessage());
		});
		return exResponse;
	}
	
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({
		PlayerNotFoundException.class,
		PlayerAlreadyPresentException.class
	})
	public Map<String, String>  handleBusinessException(Exception e){
		Map<String, String> map=new HashMap<>();
		map.put("Error Message", e.getLocalizedMessage());
		return map;
	}
}
