
package com.cg.userservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}