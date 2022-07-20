package com.cg.examservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_details")
public class User {

	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private int id;
    private String userid;
    private String uname;
    private String password;
    private boolean isAdmin;
    private String address;
    private String gender;
}