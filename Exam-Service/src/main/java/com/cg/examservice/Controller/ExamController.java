package com.cg.examservice.Controller;
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

import com.cg.examservice.entity.Exam;
import com.cg.examservice.exception.ExamNotFoundException;
import com.cg.examservice.exception.NoProperDataException;
import com.cg.examservice.serviceImpl.ExamServiceImpl;
import com.cg.examservice.serviceImpl.SequenceGeneratorService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/v1")
public class ExamController {

	@Autowired
	private ExamServiceImpl examServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	@GetMapping("/allexams")  //users/admin
    public ResponseEntity<List<Exam>> getAllExam() throws ExamNotFoundException {
        //productserviceimpl.getAllProducts();
        return new  ResponseEntity<>(examServiceImpl.getAllExams(),HttpStatus.OK);
    }

    
     //admin/users 
      @GetMapping("/getexam/{id}") 
      public ResponseEntity<Exam> getExamById(@PathVariable Integer id) throws ExamNotFoundException {
    	  Exam exam= examServiceImpl.getExamById(id);
          return ResponseEntity.ok().body(exam);
      }

    @PostMapping("/addexam")  //only admin
    public ResponseEntity<Exam> addExam(@RequestBody Exam exam) throws NoProperDataException {
    	exam.setId(sequenceGeneratorService.getSequenceNumberForExam(Exam.SEQUENCE_NAME));
         //productserviceimpl.addProduct(product);
         return new ResponseEntity<>(examServiceImpl.addExam(exam),HttpStatus.CREATED);
    }

    @PutMapping("/updateexam/{id}") // admin only @PutMapping("/updateproduct/{id}")
	public String updateExam(@Validated @RequestBody Exam exam)
			throws ExamNotFoundException {
		String que=examServiceImpl.updateExam(exam);
		return que;
	}
    @DeleteMapping("/deleteexam/{id}")  //only delete
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws ExamNotFoundException {
    	examServiceImpl.deleteExam(id);
         return ResponseEntity.ok(id+" deleted successfully");
    }  
}
