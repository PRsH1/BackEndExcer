package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ExcerciseForm {

    @GetMapping("Excercise/Excer")
    //처음에 출력되는 화면은 get메소드
    public String text1(Model model) {

    	model.addAttribute("parameter", 0);
        return "Excercise/Excer";
    }

    @PostMapping("Excercise/Excer")
    public String text1(Model model, Integer parameter) {

    	model.addAttribute("parameter", calc(parameter));
        System.out.println(parameter);
        return "Excercise/Excer";
    }
    private int calc(int number1) {
        int result = number1;
        result++;
        return result;
    }




}
