package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Test3 {
	@GetMapping("exam/test3")
	public String examTest3(Model model) {


		return "redirect:test2";
	}

	@PostMapping("exam/test3")
	public String Test3(Model model){

		return "exam/test3";
	}

}
