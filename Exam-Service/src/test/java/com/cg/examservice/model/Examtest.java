package com.cg.examservice.model;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import com.cg.examservice.entity.Exam;
public class Examtest {
	Exam e1;
	@BeforeEach
	public void before() {
		Exam e1 = new Exam(100,1,99,1,"2022-03-04", "Pass");
	}
	
	
	@AfterEach
	public void after() {
		e1=null;
	}
	
//	@Test
//	void testGetExamId() {
//		assertEquals(100, e1.getId());
//	}
//
//	@Test
//	void testGettest_id() {
//		assertEquals(1, e1.getTest_id());
//	}
//
//	@Test
//	void testGettestScore() {
//		assertEquals(99, e1.getTestScore());
//	}
//	
//	@Test
//     void testGetuserid() {
//		assertEquals(1,e1.getUserid());
//	}
//	
//	@Test
//	void testGettestDate() {
//		assertEquals("2022-03-04", e1.getTestDate());
//	}
//
//	@Test
//	void testGetstatus() {
//		assertEquals("Pass", e1.getStatus());
//	}
//	
//
//	@Test
//	void testSetExamId() {
//		e1.setId(100);
//		assertEquals(101, e1.getId());
//	}
//
//	@Test
//	void testSettest_id() {
//		e1.setTest_id(1);
//		assertEquals(1, e1.getTest_id());
//	}
//
//	@Test
//	void testtestScore() {
//		e1.setTestScore(99);
//		assertEquals(99,e1.getTestScore());
//	}
//
//	@Test
//	void testSetuserid() {
//		e1.setUserid(1);
//		assertEquals(1,e1.getUserid());
//	}
//	@Test
//	void testSettestDate() {
//		e1.setTestDate("2022-03-04");
//		assertEquals("2022-03-04", e1.getTestDate());
//	}
//	
//	@Test
//	void testSetstatus() {
//		e1.setStatus("Pass");
//		assertEquals("Pass", e1.getStatus());
//	}
//
//
//	

}
