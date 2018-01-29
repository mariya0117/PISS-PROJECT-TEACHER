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

import piss.teacher.dao.Answer;
import piss.teacher.dao.Question;
import piss.teacher.reponses.QuestionResponse;
import piss.teacher.repositories.AnswerRepository;
import piss.teacher.repositories.QuestionRepository;
import piss.teacher.requests.AddQuestionRequest;
import piss.teacher.requests.AddQuestionRequest.AnswerRequest;

@RestController()
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @RequestMapping(value = "/{testId}/question", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addQuestion(@PathVariable("testId") String testId, @RequestBody AddQuestionRequest question) {
        Question questionEntity = new Question();
        questionEntity.setQuestion(question.getQuestionText());
        questionEntity.setTestId(new ObjectId(testId));

        Question reloadedEntity = questionRepository.save(questionEntity);
        ObjectId questionId = reloadedEntity.getId();
        for (AnswerRequest answerReqest : question.getAnswers()) {
            Answer answerEntity = new Answer();
            answerEntity.setAnswer(answerReqest.getAnswerText());
            answerEntity.setIsCorrect(answerReqest.getIsCorrect());
            answerEntity.setQuestionId(questionId);
            answerRepository.save(answerEntity);
        }
    }

    @RequestMapping(value = "/{testId}/questions/{questionId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuestionResponse getQuestionById(@PathVariable("testId") String testId,
            @PathVariable("questionId") String questionId) {
        Question question = questionRepository.findOne(new ObjectId(questionId));
        QuestionResponse response = convertQuestion(question);
        return response;
    }

    private QuestionResponse convertQuestion(Question question) {
        QuestionResponse response = new QuestionResponse();
        response.setQuestion(question);
        List<Answer> answers = answerRepository.findByQuestionId(question.getId());
        response.setAnswers(answers);
        return response;
    }

    @RequestMapping(value = "/{testId}/questions", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<QuestionResponse> getAllQuestions(@PathVariable("testId") String testId) {
        List<Question> questions = questionRepository.findByTestId(new ObjectId(testId));
        List<QuestionResponse> response = new ArrayList<>();
        for (Question question : questions) {
            QuestionResponse questionResponse = convertQuestion(question);
        }
        return response;
    }
}
