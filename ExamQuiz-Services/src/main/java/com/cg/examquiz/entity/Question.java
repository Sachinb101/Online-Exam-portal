package com.cg.examquiz.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//getter setter method :by using this we can get and set the data
@Data
//parameterized  constructors:by using this initialized the value
@AllArgsConstructor
//no argument constructor:by using using the address class
@NoArgsConstructor

public class Question {
	
	public static final String SEQUENCE_NAME = "question_sequence";
	@Id
	private int id;
	private String description;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private int answer;
	private int marks;
}
	