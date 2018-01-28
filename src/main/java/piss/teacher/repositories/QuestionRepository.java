package piss.teacher.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import piss.teacher.dao.Question;

public interface QuestionRepository extends CrudRepository<Question, ObjectId> {

    List<Question> findByTestId(ObjectId testId);

}
