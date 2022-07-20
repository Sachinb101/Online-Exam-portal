package com.cg.questionservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.questionservice.entity.Question;
import com.cg.questionservice.exception.NoProperDataException;
import com.cg.questionservice.exception.QuestionNotFoundException;
import com.cg.questionservice.serviceImpl.QuestionServiceImpl;
import com.cg.questionservice.serviceImpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class QuestionController {
	@Autowired
	private QuestionServiceImpl questionServiceImpl;
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	@GetMapping("/allquestions")  //users/admin
    public ResponseEntity<List<Question>> getAllQuestions() throws QuestionNotFoundException {
        //productserviceimpl.getAllProducts();
        return new  ResponseEntity<>(questionServiceImpl.getAllQuestions(),HttpStatus.OK);
    }
	
	//admin/users 
    @GetMapping("/getquestion/{id}") 
    public ResponseEntity<Question> getQuestionById(@PathVariable Integer id) throws QuestionNotFoundException {
    	Question question= questionServiceImpl.getQuestionById(id);
        return ResponseEntity.ok().body(question);
    }

    @PostMapping("/addquestion")  //only admin
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) throws NoProperDataException {
    	question.setId(sequenceGeneratorService.getSequenceNumberForQuestion(Question.SEQUENCE_NAME));
         //productserviceimpl.addProduct(product);
         return new ResponseEntity<>(questionServiceImpl.addQuestion(question),HttpStatus.CREATED);
    }
	
    @PutMapping("/updatequestion/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public String updateGlass(@Validated @RequestBody Question question)
			throws QuestionNotFoundException {
		String que=questionServiceImpl.updateQuestion(question);
		return que;
	}
    
    @DeleteMapping("/deletequestion/{id}")  //only delete
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws QuestionNotFoundException {
    	questionServiceImpl.deleteQuestion(id);
         return ResponseEntity.ok(id+" deleted successfully");
    }  
}
