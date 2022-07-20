package com.cg.testservices.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.testservices.entity.Test;
import com.cg.testservices.exception.NoProperDataException;
import com.cg.testservices.exception.TestNotFoundException;



public interface TestService {
	public List<Test> getAllTests() throws TestNotFoundException;
    public Test addTest(Test test)  throws NoProperDataException;
    public Test updateTest(Test test, Integer id) throws TestNotFoundException;
    public String deleteTest(Integer id) throws TestNotFoundException;
    public Test getTestById(Integer id) throws TestNotFoundException;
}
