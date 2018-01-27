package piss.teacher.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

import piss.teacher.dao.Test;

public interface TestRepository extends CrudRepository<Test, ObjectId> {

}
