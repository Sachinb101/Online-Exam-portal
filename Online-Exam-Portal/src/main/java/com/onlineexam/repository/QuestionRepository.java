package com.onlineexam.repository;

import com.onlineexam.models.Question;
import com.onlineexam.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> findByTest(Test test);
}
