package piss.teacher.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import piss.teacher.dao.Test;
import piss.teacher.repositories.TestRepository;

@Controller
public class PageController {

    @Autowired
    TestRepository testRepository;

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
        return "test/new";
    }

    @RequestMapping("/test/results")
    public String getResults(Model model){
        return "test/results";
    }

    @RequestMapping("/test/all")
    public String getTests(Model model){
        return "test/all";
    }

    @RequestMapping("/test")
    public void saveTest(@RequestBody Test test){
        testRepository.save(test);
    }
}
