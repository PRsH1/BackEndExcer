package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
public class exam4Controller {
	 @GetMapping("exam4")
	    public String exam4(Model model, Student student) {
		    student.setName("이승현");
		    student.setSemester(7);
		    student.setStudentNumber("201732022");
	        model.addAttribute("student",student);
	        
	        return "exam4";
	    }

	    @PostMapping("exam4")
	    public String test3(Model model, Student student) {
	        model.addAttribute("message", "저장되었습니다");
	        return "exam4";
	    }

}
