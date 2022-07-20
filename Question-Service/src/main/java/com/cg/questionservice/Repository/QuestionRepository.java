package com.cg.questionservice.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.questionservice.entity.Question;


@Repository
public interface QuestionRepository extends MongoRepository<Question, Integer> {

}