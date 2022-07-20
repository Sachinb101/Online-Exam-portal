package com.cg.examservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cg.examservice.entity.Exam;
import com.cg.examservice.serviceImpl.ExamServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;



public class ExamControllerTest {
	@MockBean
	private ExamServiceImpl examServiceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testPlanterServiceNotNull() {
		assertThat(examServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
	@Test
	void testShowExams() throws Exception {
		Exam e1= new  Exam(100,1,99,1,"2022-03-04", "Pass");
		Exam e2= new Exam(200,1, 45,1,"2022-03-04", "fail");;
		List<Exam> examList=new ArrayList<Exam>();
		examList.add(e1);
		examList.add(e2);
		when(examServiceImpl.getAllExams()).thenReturn(examList);
	mockMvc.perform(get("/exam/allexams"))
	.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	//.andExpect(jsonPath("$[*]", hasSize(2)))
	.andExpect(jsonPath("$[0].ExamId").value(100))
	.andExpect(jsonPath("$[0].test_id").value(1))
	.andExpect(jsonPath("$[0].testScore").value(99))
	.andExpect(jsonPath("$[0].userid").value(1))
	.andExpect(jsonPath("$[0].testDate").value("2022-03-04"))
	.andExpect(jsonPath("$[0].status").value("Pass"));
		
	}
	
	

//	@Test
//	void testShowPlantersById() throws Exception {
//		Planter p2= new Planter(2001,10, "brown","round",20, 100);
//			when(planterServiceImpl.getPlanterById(2001)).thenReturn(p2);
//	mockMvc.perform(get("/planter/planters/2001"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	.andExpect(jsonPath("$[0].planterId").value(2001))
//	.andExpect(jsonPath("$[0].planterHeight").value(10))
//	.andExpect(jsonPath("$[0].planterShape").value("round"))
//	.andExpect(jsonPath("$[0].planterStock").value(20))
//	.andExpect(jsonPath("$[0].planterColor").value("brown"))
//	.andExpect(jsonPath("$[0].planterCost").value(100));
//		
//	}
	
	
	@Test
	void testShowExamnvalidId() throws Exception {
		Exam e1= new Exam(100,1,99,1,"2022-03-04", "Pass");
	when(examServiceImpl.getExamById(2000)).thenReturn(e1);
	MvcResult result=mockMvc.perform(get("/exam/exams/2"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Exam with the id 2 doesn't exist");
		
	}
	
	
	@Test
	void testDeleteExamById() throws Exception {
	
		Exam e1 = new Exam(100,1,99,1,"2022-03-04", "Pass");
		String s="deleted successfully....";
	when(examServiceImpl.deleteExam(100)).thenReturn(s);
	mockMvc.perform(delete("/exam/exams/101"))
	.andExpect(status().isOk())
	.andExpect(content().string(s));	
	}
	
	@Test
	void testdeletePlanterInvalidId() throws Exception {
		Exam e1 = new Exam(100,1,99,1,"2022-03-04", "Pass");
		String s="deleted successfully....";
		when(examServiceImpl.deleteExam(20)).thenReturn(s);
	MvcResult result=mockMvc.perform(delete("/exam/exams/20"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Exam with the id 20 doesn't exist");
		
	}
	
	@Test
	void testAddExam() throws Exception {
		Exam e1 = new Exam(100,1,99,1,"2022-03-04", "Pass");
		String s= "added  Exam successfully";
		when(examServiceImpl.addExam(e1)).thenReturn(e1);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(e1);
	mockMvc.perform(post("/exam/addexams/")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isCreated());
	}
	
	@Test
	void testUpdateExam() throws Exception {
		Exam e1 = new Exam(100,1,99,1,"2022-03-04", "Pass");
		String s="updated successfully....";
		when(examServiceImpl.updateExam(e1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(e1);
	mockMvc.perform(put("/planter/updateplanter/")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isOk())
	.andExpect(content().string(s));
		
	}
}


