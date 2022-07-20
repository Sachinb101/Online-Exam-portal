package com.cg.testservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TestNotFoundException extends Exception {

	public TestNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
