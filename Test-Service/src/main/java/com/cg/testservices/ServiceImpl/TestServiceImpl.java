package com.cg.testservices.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.testservices.Repository.TestRepository;
import com.cg.testservices.Service.TestService;
import com.cg.testservices.entity.Test;
import com.cg.testservices.exception.NoProperDataException;
import com.cg.testservices.exception.TestNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;

	@Override
	public List<Test> getAllTests() throws TestNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all tests  from here");
        if (testRepository.findAll().isEmpty()) {
            throw new TestNotFoundException("No Test Found");
        } else {
            return testRepository.findAll();
        }
	}

	@Override
	public Test addTest(Test test) throws NoProperDataException {
		// TODO Auto-generated method stub
		Test tests = testRepository.save(test);
        if (tests == null) {
            throw new NoProperDataException("Please fill fields");
        }
        return tests;
    }
	

	@Override
	public Test updateTest(Test test, Integer id) throws TestNotFoundException {
		// TODO Auto-generated method stub
		 log.info("update");
		 Test tests = testRepository.findById(id)
	                .orElseThrow(() -> new TestNotFoundException("No Test Availble wth this id"));
		 tests.setTest_id( test.getTest_id());
		 tests.setTestName( test.getTestName());
		 tests.setCreated( test.getCreated());
		 final Test updatedtest = testRepository.save(tests);
	        return updatedtest;
	        // ResponseEntity.ok(updatedProduct);
	    }
	

	@Override
	public String deleteTest(Integer id) throws TestNotFoundException {
		// TODO Auto-generated method stub
		log.info("delete By Id");
        var isRemoved = testRepository.findById(id);
        if (isRemoved.isPresent()) {
        	testRepository.deleteById(id);
            log.debug("deleted succesfully {}", isRemoved.get());
        } else {
            throw new TestNotFoundException("test not available to delete on given id");
        }
        log.info("end");
        return "deleted";
	}

	@Override
	public Test getTestById(Integer id) throws TestNotFoundException {
		// TODO Auto-generated method stub
		Test test = testRepository.findById(id)
                .orElseThrow(() -> new TestNotFoundException("Test Not Found with id " + id));
        return test;
        // ResponseEntity.ok().body(lo);
        // getById id takes only id has input (it will not take object Product product)

    }
	}

//	@Override
//	public ResponseEntity<List<Test>> getAllTest() throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("get all test from here");
//		return new ResponseEntity<>(testRepository.findAll(), HttpStatus.OK);
//	}
//
//	@Override
//	public ResponseEntity<Test> getTestById(int id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		Test test = testRepository.findById(id)
//				.orElseThrow(() -> new TestNotFoundException("Test Not Found" + id));
//
//		return ResponseEntity.ok().body(test);
//	}
//
//	@Override
//	public ResponseEntity<Test> addTest(Test test) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (test != null) {
//			testRepository.save(test);
//			System.out.println("test added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(test);
//		}
//
//	@Override
//	public ResponseEntity<Test> updateTest(Test test, int id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		Test Test = testRepository.findById(id)
//				.orElseThrow(() -> new TestNotFoundException("test not available for thid id: " + id));
//		test.setTest_id(test.getTest_id());
//		test.setTestName(test.getTestName());
//		test.setCreated(test.getCreated());
//	
//		
//	
//		final Test updatedTest = testRepository.save(test);
//		return ResponseEntity.ok(updatedTest);
//	}
//	
//
//	@Override
//	public ResponseEntity<String> deleteTest(Integer id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved =testRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			testRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new TestNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id+" deleted successfully");
//	}
//}
//		
//	@Override
//		public ResponseEntity<List<Test>> getAllTest() throws TestNotFoundException {
//			// TODO Auto-generated method stub
//			log.info("get all test from here");
//			return new ResponseEntity<>(testRepository.findAll(), HttpStatus.OK);
//		}
//	
//
//	@Override
//	public ResponseEntity<Test> getTestById(int id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		Test test = testRepository.findById(id)
//				.orElseThrow(() -> new TestNotFoundException("Test Not Found" + id));
//
//		return ResponseEntity.ok().body(test);
//	}
//
//	@Override
//	public ResponseEntity<Test> addTest(Test test) throws NoProperDataException {
//		// TODO Auto-generated method stub
//		log.info("start");
//		if (test != null) {
//			testRepository.save(test);
//			System.out.println("test added");
//		} else {
//			throw new NoProperDataException("Please fill fields");
//		}
//		return ResponseEntity.ok(test);
//	}
//
//	@Override
//	public ResponseEntity<Test> updateTest(Test test, int id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		Test Test = testRepository.findById(id)
//				.orElseThrow(() -> new TestNotFoundException("test not available for thid id: " + id));
//		test.setTest_id(test.getTest_id());
//		test.setTestName(test.getTestName());
//		test.setCreated(test.getCreated());
//	
//		
//	
//		final Test updatedTest = testRepository.save(test);
//		return ResponseEntity.ok(updatedTest);
//	}
//
//	@Override
//	public ResponseEntity<String> deleteTest(Integer id) throws TestNotFoundException {
//		// TODO Auto-generated method stub
//		log.info("Start delete");
//		var isRemoved =testRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			testRepository.deleteById(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new TestNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return ResponseEntity.ok(id+" deleted successfully");
//	}
//}
//	