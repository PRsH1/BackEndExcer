package net.skhu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller

public class exam1Controller {

	
	 @GetMapping("exam1")
	    public String exam1(Model model,String studentNo,String name,String semester) {
	       
		 model.addAttribute("studentNo","201732022");
		 model.addAttribute("name","이승현");
		 model.addAttribute("semester","7");
	        return "exam1";
	    }


}
