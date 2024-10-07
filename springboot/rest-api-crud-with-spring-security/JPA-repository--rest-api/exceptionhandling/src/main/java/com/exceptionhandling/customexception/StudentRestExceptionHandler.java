package com.exceptionhandling.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessageString(e.getMessage());
		studentErrorResponse.setTimestamp(System.currentTimeMillis());

		return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}
}
