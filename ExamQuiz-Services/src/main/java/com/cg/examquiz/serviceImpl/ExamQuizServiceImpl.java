package com.cg.examquiz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.examquiz.Repository.ExamQuizRepository;
import com.cg.examquiz.entity.ExamQuiz;
import com.cg.examquiz.exeption.ExamQuizNotFoundException;
import com.cg.examquiz.exeption.NoProperDataException;
import com.cg.examquiz.service.ExamQuizService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ExamQuizServiceImpl implements ExamQuizService {

	@Autowired
	private ExamQuizRepository examquizRepository;

	@Override
	public List<ExamQuiz> getAllExamQuizs() throws ExamQuizNotFoundException {
		// TODO Auto-generated method stub
		 log.info("get all customers  from here");
       if (examquizRepository.findAll().isEmpty()) {
           throw new ExamQuizNotFoundException("No ExamQuiz Found");
       } else {
           return examquizRepository.findAll();
       }
	}

	@Override
	public ExamQuiz addExamQuiz(ExamQuiz examquiz) throws NoProperDataException {
		// TODO Auto-generated method stub
		ExamQuiz examquizs = examquizRepository.save(examquiz);
      if (examquizs == null) {
        throw new NoProperDataException("Please fill fields");
     }
      return examquizs;
	}

	@Override
	public ExamQuiz updateExamQuiz(ExamQuiz examquiz, Integer id) throws ExamQuizNotFoundException {
		// TODO Auto-generated method stub
		 log.info("update");
		 ExamQuiz examquizs = examquizRepository.findById(id)
               .orElseThrow(() -> new ExamQuizNotFoundException("No ExamQuiz Available with this id"));
					examquizs.setId(examquizs.getId());
					examquizs.setQno(examquizs.getQno());
					examquizs.setTest(examquizs.getTest());
					examquizs.setExam(examquiz.getExam());
			    	examquizs.setQuestion(examquiz.getQuestion());
			    	final ExamQuiz updatedexamquiz = examquizRepository.save(examquizs);
			        return updatedexamquiz;
			        // ResponseEntity.ok(updatedProduct);
			    }
	
	@Override
	public String deleteExamQuiz(Integer id) throws ExamQuizNotFoundException {
		// TODO Auto-generated method stub
		 log.info("delete By Id");
       var isRemoved = examquizRepository.findById(id);
       if (isRemoved.isPresent()) {
    	   examquizRepository.deleteById(id);
           log.debug("deleted succesfully {}", isRemoved.get());
       } else {
           throw new ExamQuizNotFoundException("ExamQuiz not available to delete on given id");
       }
       log.info("end");
       return "deleted";
	}

	@Override
	public ExamQuiz getExamQuizById(Integer id) throws ExamQuizNotFoundException {
		// TODO Auto-generated method stub
		ExamQuiz examquiz = examquizRepository.findById(id)
	                .orElseThrow(() -> new ExamQuizNotFoundException("ExamQuiz Not Found with id " + id));
	        return examquiz;
	        // ResponseEntity.ok().body(lo);
	        // getById id takes only id has input (it will not take object Product product)

	    }
	}

	
	
//
//    @Override
//    public List<Frame> getAllFrames() throws FrameNotFoundException {
//        // TODO Auto-generated method stub
//        log.info("get all customers  from here");
//        if (frameRepository.findAll().isEmpty()) {
//            throw new FrameNotFoundException("No Frame Found");
//        } else {
//            return frameRepository.findAll();
//        }
//    }
//
//    @Override
//    public Frame addFrame(Frame frame) throws NoProperDataException {
//        // TODO Auto-generated method stub
//        Frame frames = frameRepository.save(frame);
//        if (frames == null) {
//            throw new NoProperDataException("Please fill fields");
//        }
//        return frames;
//    }
//
//    @Override
//    public Frame updateFrame(Frame frame, Integer id) throws FrameNotFoundException {
//        // TODO Auto-generated method stub
//        log.info("update");
//        Frame frames = frameRepository.findById(id)
//                .orElseThrow(() -> new FrameNotFoundException("No customer Availble wth this id"));
//        frames.setFrame_name(frame.getFrame_name());
//        frames.setFrameColour(frame.getFrameColour());
//        frames.setFrameShape(frame.getFrameShape());
//        frames.setFrameSize(frame.getFrameSize());
//        frames.setFrameprice(frame.getFrameprice());
//        frames.setDescription(frame.getDescription());
//
//        final Frame updatedframe = frameRepository.save(frames);
//        return updatedframe;
//        // ResponseEntity.ok(updatedProduct);
//    }
//
//    @Override
//    public String deleteFrame(Integer id) throws FrameNotFoundException {
//        // TODO Auto-generated method stub
//        log.info("delete By Id");
//        var isRemoved = frameRepository.findById(id);
//        if (isRemoved.isPresent()) {
//            frameRepository.deleteById(id);
//            log.debug("deleted succesfully {}", isRemoved.get());
//        } else {
//            throw new FrameNotFoundException("frame not available to delete on given id");
//        }
//        log.info("end");
//        return "deleted";
//    }
//
//    @Override
//    public Frame getFrameById(Integer id) throws FrameNotFoundException {
//        // TODO Auto-generated method stub
//        Frame frame = frameRepository.findById(id)
//                .orElseThrow(() -> new FrameNotFoundException("Frame Not Found with id " + id));
//        return frame;
//        // ResponseEntity.ok().body(lo);
//        // getById id takes only id has input (it will not take object Product product)
//
//    }
//	@Override
//	public ResponseEntity<List<ExamQuiz>> getAllExamQuiz() throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all examquiz from here");
//	return new ResponseEntity<>(examquizRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> getExamQuizById(int id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		ExamQuiz examquiz=examquizRepository.findById(id).orElseThrow(()-> new  ExamQuizNotFoundException("customer Not Found"+id));
//	
//		return ResponseEntity.ok().body(examquiz);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> addExamQuiz(ExamQuiz examquizs) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (examquizs != null) {
//			examquizRepository.save(examquizs);
//			System.out.println("examquiz added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(examquizs);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> updateExamQuizs(ExamQuiz examquiz, int id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		ExamQuiz examquizs = examquizRepository.findById(id)
//				.orElseThrow(() -> new ExamQuizNotFoundException("examquiz not available for thid id: " + id));
//        
//		examquizs.setId(examquizs.getId());
//		examquizs.setQno(examquizs.getQno());
//		examquizs.setTest(examquizs.getTest());
//		examquizs.setExam(examquiz.getExam());
//    	examquizs.setQuestion(examquiz.getQuestion());
//		
//    	final ExamQuiz updatedExamQuiz = examquizRepository.save(examquiz);
//		return ResponseEntity.ok(updatedExamQuiz);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteExamQuiz(Integer id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved =examquizRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			examquizRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new ExamQuizNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id+" deleted successfully");
//	}
//	}

//	@Override
//	public ResponseEntity<List<ExamQuiz>> getAllExamQuiz() throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all examquiz from here");
//		return new ResponseEntity<>(examquizRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> getExamQuizById(int id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		ExamQuiz examquiz=examquizRepository.findById(id).orElseThrow(()-> new  ExamQuizNotFoundException("customer Not Found"+id));
//		
//		return ResponseEntity.ok().body(examquiz);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> addExamQuiz(ExamQuiz examquizs) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (examquizs != null) {
//			examquizRepository.save(examquizs);
//			System.out.println("examquiz added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(examquizs);
//	}
//
//	@Override
//	public ResponseEntity<ExamQuiz> updateExamQuizs(ExamQuiz examquiz, int id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		ExamQuiz examquizs = examquizRepository.findById(id)
//				.orElseThrow(() -> new ExamQuizNotFoundException("examquiz not available for thid id: " + id));
//        
//		examquizs.setId(examquizs.getId());
//		examquizs.setQno(examquizs.getQno());
//		examquizs.setTest(examquizs.getTest());
//		examquizs.setExam(examquiz.getExam());
//    	examquizs.setQuestion(examquiz.getQuestion());
//		
//    	final ExamQuiz updatedExamQuiz = examquizRepository.save(examquiz);
//		return ResponseEntity.ok(updatedExamQuiz);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteExamQuiz(Integer id) throws ExamQuizNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved =examquizRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			examquizRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new ExamQuizNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id+" deleted successfully");
//	}
//	}