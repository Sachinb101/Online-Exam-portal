package com.cg.examquiz.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.examquiz.entity.ExamQuiz;
import com.cg.examquiz.exeption.ExamQuizNotFoundException;
import com.cg.examquiz.exeption.NoProperDataException;
import com.cg.examquiz.serviceImpl.ExamQuizServiceImpl;
import com.cg.examquiz.serviceImpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ExamQuizController {
	@Autowired
	private ExamQuizServiceImpl examquizServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	 @GetMapping("/allexamquizs")  //users/admin
	    public ResponseEntity<List<ExamQuiz>> getAllFrames() throws ExamQuizNotFoundException {
	        //productserviceimpl.getAllProducts();
	        return new  ResponseEntity<>(examquizServiceImpl.getAllExamQuizs(),HttpStatus.OK);
	    }

	     //admin/users 
	      @GetMapping("/getexamquiz/{id}") 
	      public ResponseEntity<ExamQuiz> getFrameById(@PathVariable Integer id) throws ExamQuizNotFoundException {
	    	  ExamQuiz examquiz= examquizServiceImpl.getExamQuizById(id);
	          return ResponseEntity.ok().body(examquiz);
	      }

	    @PostMapping("/addexamquiz")  //only admin
	    public ResponseEntity<ExamQuiz> addExamQuiz(@RequestBody ExamQuiz examquiz) throws NoProperDataException {
	    	examquiz.setId(sequenceGeneratorService.getSequenceNumberForExamQuiz(ExamQuiz.SEQUENCE_NAME));
	         //productserviceimpl.addProduct(product);
	         return new ResponseEntity<>(examquizServiceImpl.addExamQuiz(examquiz),HttpStatus.CREATED);
	    }

	    @PutMapping("/updateexamquiz/{id}")  //admin only @PutMapping("/updateproduct/{id}") 
	    public ResponseEntity<ExamQuiz> updateExamQuiz(@RequestBody ExamQuiz examquiz,@PathVariable Integer id) throws ExamQuizNotFoundException {
	        ;
	         return ResponseEntity.ok(examquizServiceImpl.updateExamQuiz(examquiz,id));
	    }

	    @DeleteMapping("/deleteexamquiz/{id}")  //only delete
	    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws ExamQuizNotFoundException {
	    	examquizServiceImpl.deleteExamQuiz(id);
	         return ResponseEntity.ok(id+" deleted successfully");
	    } 
}
//	@GetMapping("/allexamquiz") 
//	public ResponseEntity<List<ExamQuiz>> getAllExamQuizs() throws ExamQuizNotFoundException
//	{
//		log.info("starting  of get mapping");
//		return examquizServiceImpl.getAllExamQuiz();
//	}
//	
//	@GetMapping("/examquiz/{id}")
//	public ResponseEntity<ExamQuiz> getExamQuizById(@PathVariable  Integer id)
//	throws ExamQuizNotFoundException{
//		return examquizServiceImpl.getExamQuizById(id);
//	}
//	
//	@PostMapping("/addexamquiz") 
//	public ResponseEntity<ExamQuiz> addCustomer(@RequestBody ExamQuiz examquiz)  throws NoProperDataException
//	{
//		log.info("start");
//		examquiz.setId(sequenceGeneratorService.getSequenceNumberForExamQuiz(ExamQuiz.SEQUENCE_NAME));
//		return examquizServiceImpl.addExamQuiz(examquiz);
//	}
//	
//	
//	@PutMapping("/updateexamquiz/{id}")
//	public ResponseEntity<ExamQuiz> updateExamQuiz(@RequestBody ExamQuiz examquiz,@PathVariable int id) throws ExamQuizNotFoundException
//	{
//		return examquizServiceImpl.updateExamQuizs(examquiz, id);
//	}
//	
//	
//	@DeleteMapping(path="/deleteexamquiz/{id}")
//	public ResponseEntity<String> deleteExamQuiz(@PathVariable int id) throws ExamQuizNotFoundException {
//			return examquizServiceImpl.deleteExamQuiz(id);
//	}
//}
