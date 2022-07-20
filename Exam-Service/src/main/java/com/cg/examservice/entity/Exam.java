package com.cg.examservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "exam_details")
public class Exam {
	public static final String SEQUENCE_NAME = "exam_sequence";
//   exam_information:id,test,testScore,user,testDate,status
	@Id
    private int id;
    private int test_id;
    private int testScore;
    private int userid;
    private String testDate;
    private String status;
}

