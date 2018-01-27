package piss.teacher.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import piss.teacher.dao.Answer;

public interface AnswerRepository extends CrudRepository<Answer, ObjectId> {

    List<Answer> findByQuestionId(ObjectId questionId);

}
