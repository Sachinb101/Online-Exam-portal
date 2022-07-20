package com.cg.question.controller;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cg.questionservice.entity.Question;
import com.cg.questionservice.serviceImpl.QuestionServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

	@MockBean
	private QuestionServiceImpl questionServiceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testQuestionServiceNotNull() {
		assertThat(questionServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
//	@Test
//	void testShowQuestions() throws Exception {
//		Question q1= new Question(2000,9, "red","oval",10, 90);
//		Question q2= new Question(2001,10, "brown","round",20, 100);
//		List<Question> questionList=new ArrayList<Planter>();
//		questionList.add(q1);
//		questionList.add(q2);
//		when(questionServiceImpl.getAllQuestions()).thenReturn(questionList);
//	mockMvc.perform(get("/question/allquestions"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	//.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].questionId").value(2000))
//	.andExpect(jsonPath("$[0].questionHeight").value(9))
//	.andExpect(jsonPath("$[0].questionShape").value("oval"))
//	.andExpect(jsonPath("$[0].questionStock").value(20))
//	.andExpect(jsonPath("$[0].questionColor").value("red"))
//	.andExpect(jsonPath("$[0].questionCost").value(200));
//		
//	}
	
	

//	@Test
//	void testShowQuestionsById() throws Exception {
//		Question p2= new Planter(2001,10, "brown","round",20, 100);
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
	void testShowQuestionInvalidId() throws Exception {
		Question q1= new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
	when(questionServiceImpl.getQuestionById(100)).thenReturn(q1);
	MvcResult result=mockMvc.perform(get("/question/questions/2"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Question with the id 2 doesn't exist");
		
	}
	
//	
//	@Test
//	void testDeletePlanterById() throws Exception {
//	
//		Planter p1 = new Planter(2000,9, "red","oval",10, 90);
//		String s="deleted successfully....";
//	when(planterServiceImpl.deletePlanter(2000)).thenReturn(s);
//	mockMvc.perform(delete("/planter/planters/2001"))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));	
//	}
//	
	@Test
	void testdeleteQuestionInvalidId() throws Exception {
		Question q1 = new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		String s="deleted successfully....";
		when(questionServiceImpl.deleteQuestion(20)).thenReturn(s);
	MvcResult result=mockMvc.perform(delete("/question/questions/11"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("Question with the id 20 doesn't exist");
		
	}
	
//	@Test
//	void testAddPlanter() throws Exception {
//		Planter p1 = new Planter(2002,9, "red","oval",10, 90);
//		Planter s= "added successfully";
//		when(planterServiceImpl.addPlanter(p1)).thenReturn(s);
//		
//		ObjectMapper mapper=new ObjectMapper();
//		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
//		String reqstr=writer.writeValueAsString(p1);
//	mockMvc.perform(post("/planter/addplanters/")
//			.contentType("application/json")
//			.content(reqstr))
//	.andExpect(status().isOk())
//	.andExpect(content().string(s));
//		
//	}
	
	@Test
	void testUpdateQuestion() throws Exception {
		Question q1 = new Question(100,"Number of primitive data types in Java are?", "6","7","8", "9","8","1");
		String s="updated successfully....";
		when(questionServiceImpl.updateQuestion(q1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(q1);
	mockMvc.perform(put("/planter/updateplanter/")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isOk())
	.andExpect(content().string(s));
		
	}
}


