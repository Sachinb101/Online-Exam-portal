package com.cg.examquiz.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cg.examquiz.entity.ExamQuiz;



public interface ExamQuizRepository extends MongoRepository<ExamQuiz, Integer> {

}