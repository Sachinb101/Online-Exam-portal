package com.cg.userservices.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//getter setter method :by using this we can get and set the data
@Data
//parameterized  constructors:by using this initialized the value
@AllArgsConstructor
//no argument constructor:by using using the address class
@NoArgsConstructor

public class User {

	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
//   	private int id;
    private int userid;
    private String uname;
    private String password;
    private boolean isAdmin;
    private String address;
    private String gender;
}