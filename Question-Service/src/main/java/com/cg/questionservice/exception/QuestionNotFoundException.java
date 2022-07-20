package com.cg.questionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends Exception {

	public QuestionNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}