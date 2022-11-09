package net.skhu.controller;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Test2 {


    @GetMapping("exam/test2")
    public String test2(Model model) {
        model.addAttribute("now", new Date());
        return "exam/test2";
    }

    @PostMapping("exam/text2")
    public String text2(Model model) {

        return "exam/test2";
    }

}
