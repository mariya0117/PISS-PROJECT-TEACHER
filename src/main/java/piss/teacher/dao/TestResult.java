package piss.teacher.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TestResult {

    @Id
    private ObjectId _id;

    private ObjectId testId;

    private String studentName;

    private String mark;

    public TestResult() {
    }

    public TestResult(ObjectId testId, String studentName, String mark) {
        this.testId = testId;
        this.studentName = studentName;
        this.mark = mark;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
