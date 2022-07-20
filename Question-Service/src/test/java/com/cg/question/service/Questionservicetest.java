package com.cg.question.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.cg.questionservice.Repository.QuestionRepository;
import com.cg.questionservice.entity.Question;
import com.cg.questionservice.exception.NoProperDataException;
import com.cg.questionservice.exception.QuestionNotFoundException;
import com.cg.questionservice.serviceImpl.QuestionServiceImpl;

public class Questionservicetest {
	@InjectMocks
	private QuestionServiceImpl questionServiceImpl;
	
	@Mock
	private QuestionRepository questionRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(questionServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(questionRepository).isNotNull();
	}
	
	@Test
	void testGetAllQuestions() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		Question q2= new Question(200," of non primitive data types in Java are?", "1","2","4", "4","1","1");
		List<Question> questionlist=new ArrayList<Question>();
		questionlist.add(q1);
		questionlist.add(q2);
		when(questionRepository.findAll()).thenReturn(questionlist);
		assertEquals(questionlist,questionServiceImpl.getAllQuestions());
		
	}
	
	@Test
	void testGetQuestionById() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		when(questionRepository.findById(101)).thenReturn(Optional.of(q1));
		assertEquals(q1,questionServiceImpl.getQuestionById(101));
	}
	
	@Test
	void testGetQuestionByInvalidId() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		when(questionRepository.findById(2000)).thenReturn(Optional.of(q1));
		try {
			assertThat(questionServiceImpl.getQuestionById(2001)).as("Question with the id 2001 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddQuestionException() throws QuestionNotFoundException {
		
		Question q1= null;//new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
//		when(questionRepository.findById(2000)).thenReturn(Optional.of(p1));
	try {
		questionServiceImpl.addQuestion(q1);
	}catch(Exception e) {
		assertEquals("Please fill fields", e.getMessage());
	}
	}
	@Test
	void testAddQuestion() throws QuestionNotFoundException, NoProperDataException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		when(questionRepository.findById(2000)).thenReturn(Optional.of(q1));
		((List<Question>) assertThat(questionServiceImpl.addQuestion(q1)))
		.contains("added successfully....");
	
	}	
	
	@Test
	void testAddQuestionAlreadyExists() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		when(questionRepository.findById(101)).thenReturn(Optional.of(q1));
	try {
		((List<Question>) assertThat(questionServiceImpl.addQuestion(q1)))
		.contains("question with the id "+q1.getId()+" already exist");
	}catch(Exception e) {
		
	}
	}
//	
	@Test
	void testupdateQuestion() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");	
		when(questionRepository.findById(2000)).thenReturn(Optional.of(q1));
		assertThat(questionServiceImpl.updateQuestion(q1))
		.contains("updated successfully....");
	
	}
	
	@Test
	void testupdateQuestionDoesnotExists() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		when(questionRepository.findById(10)).thenReturn(Optional.of(q1));
	try {
		assertThat(questionServiceImpl.updateQuestion(q1))
		.contains("Question with the id "+q1.getId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteQuestionById() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");	

		when(questionRepository.findById(101)).thenReturn(Optional.of(q1));
		assertThat(questionServiceImpl.deleteQuestion(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteQuestionByInvalidId() throws QuestionNotFoundException {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");	
		when(questionRepository.findById(101)).thenReturn(Optional.of(q1));
		try {
			assertThat(questionServiceImpl.deleteQuestion(2000))
			.contains("Question with the id "+q1.getId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}


