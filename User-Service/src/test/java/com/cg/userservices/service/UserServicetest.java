package com.cg.userservices.service;

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

import com.cg.userservices.Repository.UserRepository;
import com.cg.userservices.ServiceImpl.UserServiceImpl;
import com.cg.userservices.entity.User;
import com.cg.userservices.exception.NoProperDataException;
import com.cg.userservices.exception.UserNotFoundException;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServicetest {
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(userServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(userRepository).isNotNull();
	}
	
	@Test
	void testGetAllUsers() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		User u2= new User(200,"Suresh","suresh@123",false,"nagpur","male");
		List<User> userlist=new ArrayList<User>();
		userlist.add(u1);
		userlist.add(u2);
		when(userRepository.findAll()).thenReturn(userlist);
		assertEquals(userlist,userServiceImpl.getAllUsers());
		
	}
	
	@Test
	void testGetUserById() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(101)).thenReturn(Optional.of(u1));
		assertEquals(u1,userServiceImpl.getUserById(101));
	}
	
	@Test
	void testGetUserByInvalidId() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(100)).thenReturn(Optional.of(u1));
		try {
			assertThat(userServiceImpl.getUserById(101)).as("User with the id 101 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddUserException() throws UserNotFoundException {
		
		User u1= null;//new User(2000,9, "red","oval",10, 90);
//		when(planterRepository.findById(2000)).thenReturn(Optional.of(p1));
	try {
		userServiceImpl.addUser(u1);
	}catch(Exception e) {
		assertEquals("Please fill fields", e.getMessage());
	}
	}
	@Test
	void testAddUser() throws UserNotFoundException, NoProperDataException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(100)).thenReturn(Optional.of(u1));
		((List<User>) assertThat(userServiceImpl.addUser(u1)))
		.contains("added successfully....");
	
	}	
	
	@Test
	void testAddUserAlreadyExists() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(101)).thenReturn(Optional.of(u1));
	try {
		((List<User>) assertThat(userServiceImpl.addUser(u1)))
		.contains("User with the id "+u1.getUserid()+" already exist");
	}catch(Exception e) {
		
	}
	}
//	
	@Test
	void testupdateUser() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(100)).thenReturn(Optional.of(u1));
		assertThat(userServiceImpl.updateUser(u1))
		.contains("updated successfully....");
	
	}
	
	@Test
	void testupdateUserDoesnotExists() throws UserNotFoundException {
		User u1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(101)).thenReturn(Optional.of(u1));
	try {
		assertThat(userServiceImpl.updateUser(u1))
		.contains("User with the id "+u1.getUserid()+" doesn't exist for update");
	}catch(Exception e) {
		
	}
	}
	
	@Test
	void testDeleteUserById() throws UserNotFoundException {
		User q1= new User(100,"Sumit","Sumit@123",false,"pune","male");

		when(userRepository.findById(101)).thenReturn(Optional.of(q1));
		assertThat(userServiceImpl.deleteUser(101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteUserByInvalidId() throws UserNotFoundException {
		User q1= new User(100,"Sumit","Sumit@123",false,"pune","male");
		when(userRepository.findById(101)).thenReturn(Optional.of(q1));
		try {
			assertThat(userServiceImpl.deleteUser(2000))
			.contains("User with the id "+q1.getUserid()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}

	
	}


