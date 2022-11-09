package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
public class exam3Controller {
	 @GetMapping("exam3")
	    public String test3(Model model) {
	        model.addAttribute("student", new Student());
	        return "exam3";
	    }

	    @PostMapping("exam3")
	    public String test3(Model model, Student student) {
	        model.addAttribute("message", "저장되었습니다");
	        return "exam3";
	    }

}
