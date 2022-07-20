package com.cg.examquiz.service;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.examquiz.entity.ExamQuiz;
import com.cg.examquiz.exeption.ExamQuizNotFoundException;
import com.cg.examquiz.exeption.NoProperDataException;



public interface ExamQuizService {
	public List<ExamQuiz> getAllExamQuizs() throws  ExamQuizNotFoundException;
    public ExamQuiz addExamQuiz(ExamQuiz examquiz)  throws NoProperDataException;
    public ExamQuiz updateExamQuiz(ExamQuiz examquiz, Integer id) throws ExamQuizNotFoundException;
    public String deleteExamQuiz(Integer id) throws ExamQuizNotFoundException;
    public ExamQuiz getExamQuizById(Integer id) throws ExamQuizNotFoundException;
}
