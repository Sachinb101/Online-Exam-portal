package com.cg.examquiz.entity;

import java.time.LocalDate;

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

public class Test {
	 public static final String SEQUENCE_NAME = "test_sequence";
	@Id
	 	private int test_id;
	    private String testName;
	    private LocalDate created;
}
