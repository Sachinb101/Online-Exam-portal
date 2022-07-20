package com.cg.examservice.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
	 public static final String SEQUENCE_NAME = "test_sequence";
	@Id
	 	private int test_id;
	    private String testName;
	    private LocalDate created;
}
