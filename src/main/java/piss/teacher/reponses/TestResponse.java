package piss.teacher.reponses;

import java.util.List;

import piss.teacher.dao.Test;

public class TestResponse {

    private Test test;

    private List<QuestionResponse> questions;

    public TestResponse() {
    }

    public TestResponse(Test test, List<QuestionResponse> questions) {
        this.test = test;
        this.questions = questions;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<QuestionResponse> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionResponse> questions) {
        this.questions = questions;
    }

}
