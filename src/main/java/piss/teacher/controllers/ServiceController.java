package piss.teacher.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import piss.teacher.dao.TestResult;
import piss.teacher.repositories.TestResultRepository;

@RestController()
public class ServiceController {

    @Autowired
    TestResultRepository testResultRepository;

    @RequestMapping(value = "/result", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveResult(@RequestBody TestResult result){
        testResultRepository.save(result);
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TestResult> getResult(){
        return (List<TestResult>) testResultRepository.findAll();
    }

}
