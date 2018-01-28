package piss.teacher.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import piss.teacher.dao.Test;
import piss.teacher.repositories.TestRepository;
import piss.teacher.repositories.TestResultRepository;

@Controller
public class PageController {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestResultRepository testResultRepository;

    @RequestMapping("/")
    public String redirectToMenu(){
        return "redirect:/menu";
    }

    @RequestMapping({"/menu"})
    public String menu(Model model){
        return "menu";
    }

    @RequestMapping("/test/new")
    public String newTest(Model model){
        model.addAttribute("test", new Test());
        return "test/new";
    }

    @RequestMapping("/test/results")
    public String getResults(Model model){
        model.addAttribute("results", testResultRepository.findAll());
        return "test/results";
    }

    @RequestMapping("/test/all")
    public String getTests(Model model){
        return "test/all";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String saveTest(@Valid Test test){
        test = testRepository.save(test);

        return "redirect:/test/questions/" + test.getId();
    }

    @RequestMapping("/test/questions/{testId}")
    public String getProduct(@PathVariable("testId") String testId, Model model){
        return "test/questions";
    }
}
