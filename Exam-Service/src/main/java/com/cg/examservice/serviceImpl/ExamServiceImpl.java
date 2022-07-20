package com.cg.examservice.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.cg.examservice.Repository.ExamRepository;
import com.cg.examservice.entity.Exam;
import com.cg.examservice.exception.ExamNotFoundException;
import com.cg.examservice.exception.NoProperDataException;
import com.cg.examservice.service.ExamService;


import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ExamServiceImpl implements ExamService{
	@Autowired
	private ExamRepository examRepository;

	@Override
	public List<Exam> getAllExams() throws ExamNotFoundException {
		// TODO Auto-generated method stub
		 log.info("get all customers  from here");
       if ( examRepository.findAll().isEmpty()) {
           throw new ExamNotFoundException("No Exam Found");
       } else {
           return  examRepository.findAll();
       }
   }
	

	@Override
	public Exam addExam(Exam exam) throws NoProperDataException {
		// TODO Auto-generated method stub
		Exam exams = examRepository.save(exam);
      if (exams == null) {
          throw new NoProperDataException("Please fill fields");
      }
      return exams;
	}

	@Override
	public String updateExam(Exam exam) throws ExamNotFoundException {
		// TODO Auto-generated method stub
		Optional<Exam> exams=examRepository.findById(exam.getId());
		Exam ex=null;
		if(!exams.isPresent()) {
			log.debug("exam not found");
			throw new ExamNotFoundException("Exam with the id "+exam.getId()+" doesn't exist for update");
			
		}else {
			ex=exams.get();
			ex.setTest_id(exam.getTest_id());
			ex.setTestScore(exam.getTestScore());
			ex.setUserid(exam.getUserid());
		    ex.setTestDate(exam.getTestDate());
			ex.setStatus(exam.getStatus());
			log.debug("updated successfully {}",ex);
		}
		
		return ex+ "\n updated successfully....";
	}
//		String exams = examRepository.findById(id)
//              .orElseThrow(() -> new ExamNotFoundException("No customer Available with this id"));
//        exams.setTest_id(exam.getTest_id());
//		exams.setTestScore(exam.getTestScore());
//		exams.setUserid(exam.getUserid());
//	    exams.setTestDate(exam.getTestDate());
//		exams.setStatus(exam.getStatus());
//
//
//      final Exam updatedexam = examRepository.save(exams);
//      return updatedexam;
//      // ResponseEntity.ok(updatedProduct);
  

	@Override
	public String deleteExam(Integer id) throws ExamNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
      var isRemoved = examRepository.findById(id);
      if (isRemoved.isPresent()) {
    	  examRepository.deleteById(id);
          log.debug("deleted succesfully {}", isRemoved.get());
      } else {
          throw new ExamNotFoundException("exam not available to delete on given id");
      }
      log.info("end");
      return "deleted";
  }
	

	@Override
	public Exam getExamById(Integer id) throws ExamNotFoundException {
		// TODO Auto-generated method stub
		Exam exam = examRepository.findById(id)
               .orElseThrow(() -> new ExamNotFoundException("Exam Not Found with id " + id));
       return exam;
       // ResponseEntity.ok().body(lo);
      // getById id takes only id has input (it will not take object Product product)
	}
}


