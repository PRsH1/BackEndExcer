package net.skhu.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class Test2 {
	@GetMapping("exam/test2")
	public String msg(Model model) {
		model.addAttribute("msg", "hello");
		return "exam/test2";
	}

	@PostMapping("exam/test2")
	public String msg(Model model, String msg){
		model.addAttribute("msg", msg);
		System.out.println(msg);
		return "exam/test2";
	}

}
