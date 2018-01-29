package piss.teacher.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Answer {

    @Id
    private ObjectId _id;

    private ObjectId questionId;

    private String answer;

    public boolean isCorrect;

    public Answer() {
    }

    public Answer(ObjectId questionId, String answer, boolean isCorrect) {
        this.questionId = questionId;
        this.answer = answer;
        this.isCorrect = isCorrect;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public ObjectId getQuestionId() {
        return questionId;
    }

    public void setQuestionId(ObjectId questionId) {
        this.questionId = questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

}
