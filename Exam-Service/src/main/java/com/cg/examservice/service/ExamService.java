package com.cg.examservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.examservice.entity.Exam;
import com.cg.examservice.exception.ExamNotFoundException;
import com.cg.examservice.exception.NoProperDataException;


//Here we implement all the business logic like get,add,update,delete
public interface ExamService {
	public List<Exam> getAllExams() throws  ExamNotFoundException;
    public Exam addExam(Exam exam)  throws NoProperDataException;
    public String updateExam(Exam exam) throws ExamNotFoundException;
    public String deleteExam(Integer id) throws ExamNotFoundException;
    public Exam getExamById(Integer id) throws ExamNotFoundException;
	
	
	
//	public ResponseEntity<List<Exam>> getAllExams() throws  ExamNotFoundException;
//	public ResponseEntity<Exam> getExamById(@PathVariable int id) throws ExamNotFoundException;
//	public ResponseEntity<Exam> addExam(@RequestBody Exam exam)  throws NoProperDataException;
//	public ResponseEntity<Exam> updateExams(@RequestBody Exam exam ,@PathVariable int id)  throws ExamNotFoundException;
//	public ResponseEntity<String> deleteExams(@PathVariable Integer id) throws ExamNotFoundException;


}
