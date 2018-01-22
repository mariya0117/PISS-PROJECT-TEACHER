package piss.teacher.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/menu";
    }

    @RequestMapping({"/menu"})
    public String listProducts(Model model){
        return "menu";
    }

    @RequestMapping("/test/new")
    public String getProduct(Model model){
        return "test/new";
    }

    @RequestMapping("/test/results")
    public String edit(Model model){
        return "test/results";
    }

    @RequestMapping("/test/all")
    public String newProduct(Model model){
        return "test/all";
    }

}
