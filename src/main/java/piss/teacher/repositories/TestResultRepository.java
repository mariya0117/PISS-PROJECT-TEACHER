package piss.teacher.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import piss.teacher.dao.TestResult;

public interface TestResultRepository extends CrudRepository<TestResult, ObjectId> {

    List<TestResult> findByTestId(ObjectId testId);

}
