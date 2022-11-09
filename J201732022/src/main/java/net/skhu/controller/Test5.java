package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.skhu.dto.Choice;
@Controller
public class Test5 {
	@GetMapping("exam/test5")
	public String color(Model model,Choice choice) {
		choice.setColor1("yellow");
		model.addAttribute("color1",choice);
		return "exam/test5";
	}

	@PostMapping("exam/test5")
	public String color(Model model, Choice choice,HttpSession session){
		String errorMsg = null;
		if(choice.getColor1().length()==0) {
			errorMsg ="color1을 입력하세요";
		}
		else if(choice.getColor1().equals(choice.getColor2())==false) {
			errorMsg ="color1과 color2값이 일치하지 않습니다";
		}
		else {
			session.setAttribute("choice", choice);
		}
		model.addAttribute("choice",choice);
		model.addAttribute("errorMsg",errorMsg);

		return "exam/test5";
	}

}
