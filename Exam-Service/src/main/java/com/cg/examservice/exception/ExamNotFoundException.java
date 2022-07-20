package com.cg.examservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ExamNotFoundException extends  Exception{
	public ExamNotFoundException(String string) {
		// TODO Auto-generated constructor stub
	}
}
