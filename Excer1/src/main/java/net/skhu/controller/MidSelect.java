package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MidSelect {
    @GetMapping("Excercise/SelectTest")
    public String select2(Model model) {
        model.addAttribute("color", "yellow");
        return "Excercise/SelectTest";
    }

    @PostMapping("Excercise/SelectTest")
    public String select2(Model model, String color){
        model.addAttribute("color",color);
        model.addAttribute("result", color);
        return "Excercise/SelectTest";
    }

}
