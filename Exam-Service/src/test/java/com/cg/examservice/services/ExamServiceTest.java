package com.cg.examservice.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.examservice.Repository.ExamRepository;
import com.cg.examservice.entity.Exam;
import com.cg.examservice.exception.ExamNotFoundException;
import com.cg.examservice.exception.NoProperDataException;
import com.cg.examservice.serviceImpl.ExamServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class ExamServiceTest {
	@InjectMocks
	private ExamServiceImpl examServiceImpl;
	
	@Mock
	private ExamRepository examRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(examServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(examRepository).isNotNull();
	}
	
	@Test
	void testGetAllPlanters() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		Exam e2= new Exam(200,1, 45,1,"2022-03-04", "fail");
		List<Exam> examlist=new ArrayList<Exam>();
		examlist.add(e1);
		examlist.add(e2);
		when(examRepository.findAll()).thenReturn(examlist);
		assertEquals(examlist,examServiceImpl.getAllExams());
		
	}
	
	@Test
	void testGetExamById() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
		assertEquals(e1,examServiceImpl.getExamById(101));
	}

	@Test
	void testGetExamByInvalidId() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
		try {
			assertThat(examServiceImpl.getExamById(101)).as("Exam with the id 101  doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddExamException() throws ExamNotFoundException {
		
		Exam e1= null;//new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
	try {
		examServiceImpl.addExam(e1);
	}catch(Exception e) {
		assertEquals("Please fill fields", e.getMessage());
	}
	}
	
	@Test
	void testAddExam() throws ExamNotFoundException, NoProperDataException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
		((List<Exam>) assertThat(examServiceImpl.addExam(e1)))
		.contains("added successfully....");
	
	}	
	
	@Test
	void testAddExamAlreadyExists() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
	try {
		((List<Exam>) assertThat(examServiceImpl.addExam(e1)))
		.contains("Planter with the id "+e1.getId()+" already exist");
	}catch(Exception e) {
		
	}
	}

	@Test
	void testupdateExam() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(2000)).thenReturn(Optional.of(e1));
		assertThat(examServiceImpl.updateExam(e1))
		.contains("updated successfully....");
	
	}
	
	@Test
	void testupdateExamDoesnotExists() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		when(examRepository.findById(10)).thenReturn(Optional.of(e1));
	try {
		assertThat(examServiceImpl.updateExam(e1))
		.contains("Exam with the id "+e1.getId()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteExamById() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
		
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
		assertThat(examServiceImpl.deleteExam(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteExamByInvalidId() throws ExamNotFoundException {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");	
		when(examRepository.findById(101)).thenReturn(Optional.of(e1));
		try {
			assertThat(examServiceImpl.deleteExam(101))
			.contains("Exam with the id "+e1.getId()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}
