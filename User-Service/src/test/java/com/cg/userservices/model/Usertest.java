package com.cg.userservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.userservices.entity.User;



public class Usertest {
	User u1;
	@BeforeEach
	public void before() {
		User u1 = new User(100,"Sumit","sumit@123",false,"pune","male");
	}
	
	
	@AfterEach
	public void after() {
		u1=null;
	}
	
	@Test
	void testGetUserid() {
		assertEquals(100, u1.getUserid());
	}

	@Test
	void testGetUseruname() {
		assertEquals("Sumit", u1.getUname());
	}

	@Test
	void testGetUserpassword() {
		assertEquals("sumit@123", u1.getPassword());
	}
	
	@Test
     void testGetUserisAdmin() {
		assertEquals(false,u1.isAdmin());
	}
	
	@Test
	void testGetUseraddress() {
		assertEquals("pune", u1.getAddress());
	}

	@Test
	void testGetUsergender() {
		assertEquals("male", u1.getGender());
	}
	
	
	@Test
	void testSetUserid() {
		u1.setUserid(100);
		assertEquals(101, u1.getUserid());
	}

	@Test
	void testSetUseruname() {
		u1.setUname("Sumit");
		assertEquals("Sumit", u1.getUname());
	}

	@Test
	void testUserpassword() {
		u1.setPassword("sumit@123");
		assertEquals("sumit@123",u1.getPassword());
	}

	@Test
	void testSetUserisAdmin() {
		u1.setAdmin(false);
		assertEquals(false,u1.isAdmin());
	}
	@Test
	void testSetUseraddress() {
		u1.setAddress("pune");
		assertEquals("pune", u1.getAddress());
	}
	
	@Test
	void testSetUsergender() {
		u1.setGender("male");
		assertEquals("male", u1.getGender());
	}


}


