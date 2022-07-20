package com.cg.testservices.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.testservices.entity.Test;



@Repository
public interface TestRepository extends MongoRepository<Test, Integer>{
}