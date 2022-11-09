package net.skhu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Test4 {
	@GetMapping("exam/test4")
	public String color(Model model) {
		model.addAttribute("color", "yellow");
		return "exam/test4";
	}

	@PostMapping("exam/test4")
	public String color(Model model, String color){
		model.addAttribute("color",color);
		System.out.println(color);
		return "exam/test4";
	}

}
