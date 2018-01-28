package piss.teacher.reponses;

import java.util.List;

import piss.teacher.dao.Answer;
import piss.teacher.dao.Question;

public class QuestionResponse {

    private Question question;

    private List<Answer> answers;

    public QuestionResponse() {
    }

    public QuestionResponse(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
