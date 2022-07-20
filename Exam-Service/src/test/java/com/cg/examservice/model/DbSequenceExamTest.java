package com.cg.examservice.model;

import org.junit.jupiter.api.AfterEach;

import com.cg.examservice.entity.Exam;

public class DbSequenceExamTest {
	Exam e1;
	
	
	@AfterEach
	public void after() {
		e1=null;
	}
}

