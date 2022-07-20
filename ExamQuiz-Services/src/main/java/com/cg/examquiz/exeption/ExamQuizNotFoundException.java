package com.cg.examquiz.exeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExamQuizNotFoundException extends Exception{
	public ExamQuizNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	}