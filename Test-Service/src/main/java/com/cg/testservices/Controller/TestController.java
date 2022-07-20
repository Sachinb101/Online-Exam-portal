package com.cg.testservices.Controller;

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

import com.cg.testservices.ServiceImpl.SequenceGeneratorService;
import com.cg.testservices.ServiceImpl.TestServiceImpl;
import com.cg.testservices.entity.Test;
import com.cg.testservices.exception.NoProperDataException;
import com.cg.testservices.exception.TestNotFoundException;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/api/v1")
public class TestController {
	@Autowired
	private TestServiceImpl testServiceImpl;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	 @GetMapping("/alltests")  //users/admin
	    public ResponseEntity<List<Test>> getAllTests() throws TestNotFoundException {
	        //productserviceimpl.getAllProducts();
	        return new  ResponseEntity<>(testServiceImpl.getAllTests(),HttpStatus.OK);
	    }
	 
	 //admin/users 
     @GetMapping("/gettest/{id}") 
     public ResponseEntity<Test> getTestById(@PathVariable Integer id) throws TestNotFoundException {
    	 Test test= testServiceImpl.getTestById(id);
         return ResponseEntity.ok().body(test);
     }
     
     @PostMapping("/addtest")  //only admin
     public ResponseEntity<Test> addTest(@RequestBody Test test) throws NoProperDataException {
    	 test.setTest_id(sequenceGeneratorService.getSequenceNumberForTest(Test.SEQUENCE_NAME));
          //productserviceimpl.addProduct(product);
          return new ResponseEntity<>(testServiceImpl.addTest(test),HttpStatus.CREATED);
     }
     @PutMapping("/updatetest/{id}")  //admin only @PutMapping("/updateproduct/{id}") 
     public ResponseEntity<Test> updateTest(@RequestBody Test test,@PathVariable Integer id) throws TestNotFoundException {
         ;
          return ResponseEntity.ok(testServiceImpl.updateTest(test,id));
     }
     
     @DeleteMapping("/deletetest/{id}")  //only delete
     public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws TestNotFoundException {
    	 testServiceImpl.deleteTest(id);
          return ResponseEntity.ok(id+" deleted successfully");
     }  
}
     
//	@GetMapping("/alltest") 
//	public ResponseEntity<List<Test>> getAllTest() throws TestNotFoundException
//	{
//		log.info("starting  of get mapping");
//		return testServiceImpl.getAllTest();
//	
//	}
//	@GetMapping("/test/{id}")
//	public ResponseEntity<Test> getTestById(@PathVariable  Integer id)
//	throws TestNotFoundException{
//		return testServiceImpl.getTestById(id);
//	}
//	
//	@PostMapping("/addtest") 
//	public ResponseEntity<Test> addTest(@RequestBody Test test)  throws NoProperDataException
//	{
//		log.info("start");
//		test.setTest_id(sequenceGeneratorService.getSequenceNumberForTest(Test.SEQUENCE_NAME));
//		return testServiceImpl.addTest(test);
//	}
//	
//	@PutMapping("/updatetests/{id}")
//	public ResponseEntity<Test> updateLenses(@RequestBody Test test,@PathVariable int id) throws TestNotFoundException
//	{
//		return testServiceImpl.updateTest(test, id);
//	}
//	
//	@DeleteMapping(path="/deletetest/{id}")
//	public ResponseEntity<String> deleteLenses(@PathVariable int id) throws TestNotFoundException {
//			return testServiceImpl.deleteTest(id);
//	}
//	
//	
//	
//	
//	
//}
