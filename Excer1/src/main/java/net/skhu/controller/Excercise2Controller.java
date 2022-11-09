package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller

public class Excercise2Controller {
    @GetMapping("Excercise/Excer2")
    public String select2(Model model) {
        model.addAttribute("number1", "one");
        model.addAttribute("number2", "one");
        return "Excercise/Excer2";
    }

    @PostMapping("Excercise/Excer2")
    public String select2(Model model, String number1){
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number1);
        return "Excercise/Excer2";
    }

}
