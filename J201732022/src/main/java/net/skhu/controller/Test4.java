package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Test4 {
	@GetMapping("exam/test4")
	public String color(Model model,String color1) {
		color1="yellow";
		model.addAttribute("color1",color1);
		return "exam/test4";
	}

	@PostMapping("exam/test4")
	public String color(Model model, String color1,String color2){

		String errorMsg = null;
		if(color1.length()==0) {
			errorMsg ="color1을 입력하세요";
		}
		else if(color1.equals(color2)==false) {
			errorMsg ="color1과 color2 값이 일치하지 않습니다";
		}


		model.addAttribute("color1",color1);
		model.addAttribute("color2",color2);
		model.addAttribute("errorMsg",errorMsg);

		return "exam/test4";
	}

}
