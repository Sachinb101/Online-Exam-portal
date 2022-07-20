package com.cg.examquiz.entity;
import java.time.LocalDate;


import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//getter setter method :by using this we can get and set the data
@Data
// parameterized  constructors:by using this initialized the value
@AllArgsConstructor
//no argument constructor:by using using the address class
@NoArgsConstructor

public class Exam {
	public static final String SEQUENCE_NAME = "exam_sequence";
//   exam_information:id,test,testScore,user,testDate,status
	@Id
    private int id;
    private int test_id;
    private int testScore;
    private int userid;
    private LocalDate testDate;
    private String status;
}

