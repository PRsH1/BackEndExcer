package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MidExcerciseController {
	 @GetMapping("Excercise/mid")
	    public String select2(Model model) {
	        model.addAttribute("number1", 0);
	        for (int i=1; i<10; i++) {
	        	String str=String.valueOf(i+1);
	        	model.addAttribute("number"+str,i);
	        	model.addAttribute("result"+str, calc(0,i));
	        }
	        return "Excercise/mid";
	    }

	    @PostMapping("Excercise/mid")
	    public String select2(Model model, Integer number1){
	        model.addAttribute("number1", number1);
	        for (int i=1; i<10; i++) {
	        	String str=String.valueOf(i+1);
	        	model.addAttribute("number"+str,i);
	        	model.addAttribute("result"+str, calc(number1,i));
	        }

	        return "Excercise/mid";
	    }
	    private int calc(Integer number1,Integer i) {
	    	return number1*i;
	    }

}
