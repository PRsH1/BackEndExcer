package net.skhu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import net.skhu.dto.MyInfo;


@Controller


public class exam2Controller {

	MyInfo info=new MyInfo("이승현",201732022,7);
	
	 @GetMapping("exam2")
	    public String exam2(Model model, MyInfo info) {
		 info.setName("이승현");
		 info.setSemester(7);
		 info.setStudentNo(201732022);
		 model.addAttribute("MyInfo",info);
	        return "exam2";
	    }


}
