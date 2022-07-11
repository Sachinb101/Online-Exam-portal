package com.onlineexam.repository;

import com.onlineexam.models.Exam;
import com.onlineexam.models.Test;
import com.onlineexam.models.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam,Integer> {
    Exam findByTestAndUser(Test test, User user);
    List<Exam> findByUser(User user);
}
