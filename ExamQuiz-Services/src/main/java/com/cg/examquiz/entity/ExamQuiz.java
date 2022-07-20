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
@Document(collection = "examquiz_details")
public class ExamQuiz<Question> {
	public static final String SEQUENCE_NAME = "examquiz sequence";
	@Id
	private int id;
	private int qno;
	private int test;
	private Exam exam;
	private String  question;
	private int userans;
}