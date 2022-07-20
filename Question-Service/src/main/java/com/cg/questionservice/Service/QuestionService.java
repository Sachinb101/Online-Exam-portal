package com.cg.questionservice.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.questionservice.entity.Question;
import com.cg.questionservice.exception.NoProperDataException;
import com.cg.questionservice.exception.QuestionNotFoundException;



public interface QuestionService {
	public List<Question> getAllQuestions() throws  QuestionNotFoundException;
    public Question addQuestion(Question question)  throws NoProperDataException;
    public String updateQuestion(Question question) throws QuestionNotFoundException;
    public String deleteQuestion(Integer id) throws QuestionNotFoundException;
    public Question getQuestionById(Integer id) throws QuestionNotFoundException;
	
	
}