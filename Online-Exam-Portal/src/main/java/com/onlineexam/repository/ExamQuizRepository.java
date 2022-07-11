package com.onlineexam.repository;

import com.onlineexam.models.Exam;
import com.onlineexam.models.ExamQuiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamQuizRepository extends JpaRepository<ExamQuiz,Integer> {
    List<ExamQuiz> findByExam(Exam exam);
}
