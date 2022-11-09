package net.skhu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Test1 {
	@GetMapping("exam/test1")
	public String examTest1(Model model) {

		model.addAttribute("myNumber","201732022");
		model.addAttribute("myName","이승현");
		return "exam/test1";
	}

	@PostMapping("exam/test1")
	public String examTest1(Model model, String myName, String myNumber){

		return "exam/test1";
	}

}
