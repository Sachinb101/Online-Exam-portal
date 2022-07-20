package com.cg.question.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.questionservice.entity.Question;

public class Questiontest {
	Question q1;
	@BeforeEach
	public void before() {
		Question q1 = new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
	}
	
	
	@AfterEach
	public void after() {
		q1=null;
	}
	
	@Test
	void testGetQuestionid() {
		assertEquals(2001, q1.getId());
	}

	@Test
	void testGetQuestiondescription() {
		assertEquals(9, q1.getDescription());
	}

	@Test
	void testGetQuestionoption1() {
		assertEquals("red", q1.getOption1());
	}
	
	@Test
     void testGetQuestionoption2() {
		assertEquals("oval",q1.getOption2());
	}
	
	@Test
	void testGetQuestionoption3() {
		assertEquals(100, q1.getOption3());
	}

	@Test
	void testGetQuestionoption4() {
		assertEquals(100, q1.getOption4());
	}
	

	@Test
	void testGetQuestionanswer() {
		assertEquals(100, q1.getAnswer());
	}
	
	

	@Test
	void testGetQuestionmarks() {
		assertEquals(100, q1.getMarks());
	}
	@Test
	void testSetQuestionid() {
		q1.setId(111);
		assertEquals(101, q1.getId());
	}

	@Test
	void testSetQuestiondescription() {
		q1.setDescription("Number of primitive data types in Java are?");
		assertEquals("Number of primitive data types in Java are?", q1.getDescription());
	}

	@Test
	void testSetQuestionoption1() {
		q1.setOption1("6");
		assertEquals("6",q1.getOption1());
	}

	@Test
	void testSetQuestionoption2() {
		q1.setOption2("7");
		assertEquals("7",q1.getOption2());
	}
	@Test
	void testSetQuestionoption3() {
		q1.setOption3("8");
		assertEquals("8", q1.getOption3());
	}
	
	@Test
	void testSetQuestionoption4() {
		q1.setOption4("9");
		assertEquals(100, q1.getOption4());
	}

	void testSetQuestionanswer() {
		q1.setAnswer("8");
		assertEquals("8", q1.getAnswer());
	}

	void testSetQuestionmarks() {
		q1.setMarks("1");
		assertEquals("1", q1.getMarks());
	}

}

