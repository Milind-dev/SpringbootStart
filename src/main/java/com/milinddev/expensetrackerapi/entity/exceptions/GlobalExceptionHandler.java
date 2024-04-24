package com.milinddev.expensetrackerapi.entity.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.milinddev.expensetrackerapi.entity.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request){
		ErrorObject errorobject = new ErrorObject();
		errorobject.setStatuscode(HttpStatus.NOT_FOUND.value());
		errorobject.setMessage(ex.getMessage());
		errorobject.setTimestamp(new Date());
		return new ResponseEntity<ErrorObject>(errorobject,HttpStatus.NOT_FOUND);
			}
}
