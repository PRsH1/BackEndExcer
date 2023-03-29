package net.skhu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.service.UserService;

@Controller
public class UserController {
	
	@Autowired UserService userService;

    @RequestMapping("user/index")
    public String index(Model model) {
        return "user/index";
    }

    @RequestMapping("user/redirect")
    public String redirect(Model model, HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/admin/index";
        if (request.isUserInRole("ROLE_PROFESSOR")) {
            return "redirect:/professor/index";
        }
        return "redirect:/user/index";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("user/admin_only")
    public String admin_only(Model model) {
    	
    	model.addAttribute("users",userService.findAll());
        return "user/admin_only";
    }

    @Secured("ROLE_PROFESSOR")
    @RequestMapping("user/professor_only")
    public String professor_only(Model model) {
        return "user/professor_only";
    }
}
