package com.cg.examservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.examservice.entity.Exam;


//repository means it is directly connected to the database by using this interface we can do all database realated operaations.
@Repository
public interface ExamRepository extends MongoRepository<Exam,Integer> {

}
