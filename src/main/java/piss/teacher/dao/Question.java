package piss.teacher.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Question {

    @Id
    private ObjectId _id;

    private ObjectId testId;

    private String question;

    public Question(ObjectId testId, String question) {
        this.testId = testId;
        this.question = question;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public ObjectId getTestId() {
        return testId;
    }

    public void setTestId(ObjectId testId) {
        this.testId = testId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
