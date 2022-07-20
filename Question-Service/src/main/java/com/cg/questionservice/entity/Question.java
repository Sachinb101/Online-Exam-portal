package com.cg.questionservice.entity;

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
@Document(collection = "question_details")
public class Question {
	
	public static final String SEQUENCE_NAME = "question_sequence";
	@Id
	private int id;
	private String description;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String marks;
}
	