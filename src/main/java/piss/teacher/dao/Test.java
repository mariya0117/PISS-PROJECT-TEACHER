package piss.teacher.dao;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Test {

    @Id
    private ObjectId _id;

    private ObjectId teacherId;

    private String subject;

    public Test(ObjectId teacherId, String subject) {
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public ObjectId getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(ObjectId teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
