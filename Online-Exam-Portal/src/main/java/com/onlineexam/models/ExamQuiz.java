package com.onlineexam.models;

import javax.persistence.*;

@Entity
public class ExamQuiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qno;
    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    @ManyToOne
    @JoinColumn(name ="question_id")
    private Question question;
    private int userans;

    public ExamQuiz() {
    }

    public ExamQuiz(int qno, Test test,Exam exam, Question question) {
        this.qno = qno;
        this.test = test;
        this.question = question;
        this.exam=exam;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        this.qno = qno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public int getUserans() {
        return userans;
    }

    public void setUserans(int userans) {
        this.userans = userans;
    }
}
