package com.cg.questionservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.questionservice.Repository.QuestionRepository;
import com.cg.questionservice.Service.QuestionService;
import com.cg.questionservice.entity.Question;
import com.cg.questionservice.exception.NoProperDataException;
import com.cg.questionservice.exception.QuestionNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuestionServiceImpl  implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> getAllQuestions() throws QuestionNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all questions  from here");
      if (questionRepository.findAll().isEmpty()) {
          throw new QuestionNotFoundException("No Question Found");
      } else {
          return questionRepository.findAll();
      }
	}
	

	@Override
	public Question addQuestion(Question question) throws NoProperDataException {
		// TODO Auto-generated method stub
		Question questions =  questionRepository.save( question);
      if ( questions == null) {
          throw new NoProperDataException("Please fill fields");
      }
      return  question;
	}

	@Override
	public String updateQuestion(Question question) throws QuestionNotFoundException {
		// TODO Auto-generated method stub
		Optional<Question> questions=questionRepository.findById(question.getId());
	Question que=null;
	if(!questions.isPresent()) {
		log.debug("question not found");
		throw new QuestionNotFoundException("Question with the id "+question.getId()+" doesn't exist for update");
		
	}else {
		que=questions.get();
		que.setId(question.getId());
		que.setDescription(question.getDescription());
		que.setOption1(question.getOption1());
		que.setOption2(question.getOption2());
		que.setOption3(question.getOption3());
		que.setOption4(question.getOption4());
		que.setAnswer(question.getAnswer());
		que.setMarks(question.getMarks());
		log.debug("updated successfully {}",que);
	}
	
	return que+ "\n updated successfully....";
	}

	@Override
	public String deleteQuestion(Integer id) throws QuestionNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
	      var isRemoved = questionRepository.findById(id);
	      if (isRemoved.isPresent()) {
	    	  questionRepository.deleteById(id);
	          log.debug("deleted succesfully {}", isRemoved.get());
	      } else {
	          throw new QuestionNotFoundException("question not available to delete on given id");
	      }
	      log.info("end");
	      return "deleted";

	}

	@Override
	public Question getQuestionById(Integer id) throws QuestionNotFoundException {
		// TODO Auto-generated method stub
				Question question = questionRepository.findById(id)
              .orElseThrow(() -> new QuestionNotFoundException("Question Not Found with id " + id));
      return question;
//       ResponseEntity.ok().body(lo);
//       getById id takes only id has input (it will not take object Product product)

	}
}
//	@Override
//	public List<Question> getAllQuestions() throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all questions  from here");
//      if (questionRepository.findAll().isEmpty()) {
//          throw new QuestionNotFoundException("No Question Found");
//      } else {
//          return questionRepository.findAll();
//      }
//	}
//
//	@Override
//	public Question addQuestion(Question question) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		Question questions =  questionRepository.save( question);
//        if ( questions == null) {
//            throw new NoProperDataException("Please fill fields");
//        }
//        return  question;
//	}
//
////	@Override
////	public String updateQuestion(Question question) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
////		Optional<Question> questions=questionRepository.findById(question.getId());
////		Question que=null;
////		if(!questions.isPresent()) {
////			log.debug("question not found");
////			throw new QuestionNotFoundException("Question with the id "+question.getId()+" doesn't exist for update");
////			
////		}else {
////			que=questions.get();
////			que.setId(question.getId());
////			que.setDescription(question.getDescription());
////			que.setOption1(question.getOption1());
////			que.setOption2(question.getOption2());
////			que.setOption3(question.getOption3());
////			que.setOption4(question.getOption4());
////			que.setAnswer(question.getAnswer());
////			que.setMarks(question.getMarks());
////			log.debug("updated successfully {}",que);
////		}
////		
////		return que+ "\n updated successfully....";
//	
//
//	@Override
//	public String deleteQuestion(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("delete By Id");
//	      var isRemoved = questionRepository.findById(id);
//	      if (isRemoved.isPresent()) {
//	    	  questionRepository.deleteById(id);
//	          log.debug("deleted succesfully {}", isRemoved.get());
//	      } else {
//	          throw new QuestionNotFoundException("question not available to delete on given id");
//	      }
//	      log.info("end");
//	      return "deleted";
//	  }
//	
//
//	@Override
//	public Question getQuestionById(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question question = questionRepository.findById(id)
//              .orElseThrow(() -> new QuestionNotFoundException("Question Not Found with id " + id));
//      return question;
////       ResponseEntity.ok().body(lo);
////       getById id takes only id has input (it will not take object Product product)

//  }
//	}
//	@Override
//	public List<Question> getAllQuestions() throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//        log.info("get all customers  from here");
//        if (questionRepository.findAll().isEmpty()) {
//            throw new QuestionNotFoundException("No Question Found");
//        } else {
//            return questionRepository.findAll();
//        }
//    }
//	
//
//	@Override
//	public Question addQuestion(Question question) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		Question questions =  questionRepository.save( question);
//	        if ( questions == null) {
//	            throw new NoProperDataException("Please fill fields");
//	        }
//	        return  question;
//	    }
//	
//
//	@Override
//	public String updateQuestion(Question question) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<Question> questions=questionRepository.findById(question.getId());
//		Question que=null;
//		if(!questions.isPresent()) {
//			log.debug("question not found");
//			throw new QuestionNotFoundException("Question with the id "+question.getId()+" doesn't exist for update");
//			
//		}else {
//			que=questions.get();
//			que.setId(question.getId());
//			que.setDescription(question.getDescription());
//			que.setOption1(question.getOption1());
//			que.setOption2(question.getOption2());
//			que.setOption3(question.getOption3());
//			que.setOption4(question.getOption4());
//			que.setAnswer(question.getAnswer());
//			que.setMarks(question.getMarks());
//			log.debug("updated successfully {}",que);
//		}
//		
//		return que+ "\n updated successfully....";
//	}
//	
//	
//
//	
////	@Override
////	public Question updateQuestion(Question question, Integer id) throws QuestionNotFoundException {
////		// TODO Auto-generated method stub
////		  log.info("update");
////		  Question questions = questionRepository.findById(id)
////	                .orElseThrow(() -> new QuestionNotFoundException("No customer Availble wth this id"));
////		  log.info("update");
//////		  questions.setId( question.getId());
////		  questions.setDescription( question.getDescription());
////		  questions.setOption1( question.getOption1());
////		  questions.setOption2( question.getOption2());
////		  questions.setOption3( question.getOption3());
////		  questions.setOption4( question.getOption4());
////		  questions.setAnswer( question.getAnswer());
////		  questions.setMarks (question.getMarks());
////		  final Question updatedquestion= questionRepository.save(questions);
////	        return updatedquestion;
////	        // ResponseEntity.ok(updatedProduct);
////	    }
////	
//
//	@Override
//	public String deleteQuestion(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("delete By Id");
//	      var isRemoved = questionRepository.findById(id);
//	      if (isRemoved.isPresent()) {
//	    	  questionRepository.deleteById(id);
//	          log.debug("deleted succesfully {}", isRemoved.get());
//	      } else {
//	          throw new QuestionNotFoundException("question not available to delete on given id");
//	      }
//	      log.info("end");
//	      return "deleted";
//	  }
//	
//
//	@Override
//	public Question getQuestionById(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question question = questionRepository.findById(id)
//                .orElseThrow(() -> new QuestionNotFoundException("Question Not Found with id " + id));
//        return question;
//        // ResponseEntity.ok().body(lo);
//        // getById id takes only id has input (it will not take object Product product)
//
//    }
//	}

//	@Override
//	public ResponseEntity<List<Question>> getAllQuestion() throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all questions from here");
//		return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<Question> getQuestionById(int id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question questions = questionRepository.findById(id)
//				.orElseThrow(() -> new QuestionNotFoundException("Question Not Found" + id));
//
//		return ResponseEntity.ok().body(questions);	
//		}
//
//	@Override
//	public ResponseEntity<Question> addQuestion(Question question) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (question != null) {
//			questionRepository.save(question);
//			System.out.println("question added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(question);
//		}
//
//	@Override
//	public ResponseEntity<Question> updateQuestion(Question examquiz, int id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question questions = questionRepository.findById(id)
//				.orElseThrow(() -> new QuestionNotFoundException("question  not available for thid id: " + id));
//        
//		questions.setDescription(questions.getDescription());
//		questions.setOption1(questions.getOption1());
//		questions.setOption2(questions.getOption2());
//		questions.setOption3(questions.getOption3());
//		questions.setOption4(questions.getOption4());
//		questions.setAnswer(questions.getAnswer());
//		questions.setMarks(questions.getAnswer());
//		final Question updatedQuestion = questionRepository.save(questions);
//		return ResponseEntity.ok(updatedQuestion);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteQuestion(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
//	@Override
//	public ResponseEntity<List<Question>> getAllQuestion() throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all questions from here");
//		return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<Question> getQuestionById(int id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question questions = questionRepository.findById(id)
//				.orElseThrow(() -> new QuestionNotFoundException("Question Not Found" + id));
//
//		return ResponseEntity.ok().body(questions);
//	}
//
//	@Override
//	public ResponseEntity<Question> addQuestion(Question question) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (question != null) {
//			questionRepository.save(question);
//			System.out.println("question added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(question);
//		}
//
//	@Override
//	public ResponseEntity<Question> updateQuestion(Question question, int id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		Question questions = questionRepository.findById(id)
//				.orElseThrow(() -> new QuestionNotFoundException("question  not available for thid id: " + id));
//        
//		questions.setDescription(question.getDescription());
//		questions.setOption1(question.getOption1());
//		questions.setOption2(question.getOption2());
//		questions.setOption3(question.getOption3());
//		questions.setOption4(question.getOption4());
//		questions.setAnswer(question.getAnswer());
//		questions.setMarks(question.getAnswer());
//		final Question updatedQuestion = questionRepository.save(questions);
//		return ResponseEntity.ok(updatedQuestion);
//	}
//	
//
//	@Override
//	public ResponseEntity<String> deleteQuestion(Integer id) throws QuestionNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved =questionRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			questionRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new QuestionNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id+" deleted successfully");
//	}
//	}	}