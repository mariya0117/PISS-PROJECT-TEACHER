package piss.teacher.controllers;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import piss.teacher.dao.Question;
import piss.teacher.dao.Test;
import piss.teacher.dao.TestResult;
import piss.teacher.reponses.QuestionResponse;
import piss.teacher.reponses.TestResponse;
import piss.teacher.repositories.AnswerRepository;
import piss.teacher.repositories.QuestionRepository;
import piss.teacher.repositories.TestRepository;
import piss.teacher.repositories.TestResultRepository;

@RestController()
public class ServiceController {

    @Autowired
    TestResultRepository testResultRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @RequestMapping(value = "/result/{testId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveResult(@PathVariable("testId") String testId, @RequestBody TestResult result) {
        result.setTestId(new ObjectId(testId));
        testResultRepository.save(result);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TestResult> getResult(){
        return (List<TestResult>) testResultRepository.findAll();
    }

    @RequestMapping(value = "/all-tests", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TestResponse> getTests(){
        List<TestResponse> response = new ArrayList<>();
        List<Test> tests = (List<Test>) testRepository.findAll();

        for (Test test : tests) {
            TestResponse testResponse = new TestResponse();
            testResponse.setTest(test);
            List<QuestionResponse> questionResopnses = new ArrayList<>();
            List<Question> questions = questionRepository.findByTestId(test.getId());

            for (Question question : questions) {
                QuestionResponse questionResponse = new QuestionResponse(question, answerRepository.findByQuestionId(question.getId()));
                questionResopnses.add(questionResponse);
            }

            testResponse.setQuestions(questionResopnses);
            response.add(testResponse);
        }

        return response;
    }
}
