package com.cg.userservices.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.cg.userservices.ServiceImpl.UserServiceImpl;
import com.cg.userservices.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@MockBean
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	MockMvc mockMvc;
	
	
	@Test
	void testUserServiceNotNull() {
		assertThat(userServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
//	@Test
//	void testShowPlanters() throws Exception {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);
//		Planter p2= new Planter(2001,10, "brown","round",20, 100);
//		List<Planter> planterList=new ArrayList<Planter>();
//		planterList.add(p1);
//		planterList.add(p2);
//		when(planterServiceImpl.getAllPlanters()).thenReturn(planterList);
//	mockMvc.perform(get("/planter/allplanters"))
//	.andExpect(status().isOk())
//	.andExpect(content().contentType("application/json"))
//	//.andExpect(jsonPath("$[*]", hasSize(2)))
//	.andExpect(jsonPath("$[0].planterId").value(2000))
//	.andExpect(jsonPath("$[0].planterHeight").value(9))
//	.andExpect(jsonPath("$[0].planterShape").value("oval"))
//	.andExpect(jsonPath("$[0].planterStock").value(20))
//	.andExpect(jsonPath("$[0].planterColor").value("red"))
//	.andExpect(jsonPath("$[0].planterCost").value(200));
//		
//	}
	
	

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
	void testShowUserInvalidId() throws Exception {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
	when(userServiceImpl.getUserById(100)).thenReturn(u1);
	MvcResult result=mockMvc.perform(get("/user/users/2"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("User with the id 2 doesn't exist");
		
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
	void testdeleteUserInvalidId() throws Exception {
		User u1 = new User(100,"Sumit","Sumit@123",false,"pune","male");
		String s="deleted successfully....";
		when(userServiceImpl.deleteUser(20)).thenReturn(s);
	MvcResult result=mockMvc.perform(delete("/user/users/11"))
	.andExpect(status().isOk())
	.andReturn();
	assertThat(result.getResponse().toString())
	.as("User with the id 20 doesn't exist");
		
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
	void testUpdatePlanter() throws Exception {
		User u1 = new User(100,"Sumit","Sumit@123",false,"pune","male");
		String s="updated successfully....";
		when(userServiceImpl.updateUser(u1)).thenReturn(s);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter  writer=mapper.writer().withDefaultPrettyPrinter();
		String reqstr=writer.writeValueAsString(u1);
	mockMvc.perform(put("/planter/updateplanter/")
			.contentType("application/json")
			.content(reqstr))
	.andExpect(status().isOk())
	.andExpect(content().string(s));
		
	}
}

	

