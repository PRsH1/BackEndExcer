package net.skhu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.User;
import net.skhu.model.UserRegister;
import net.skhu.service.DepartmentService;
import net.skhu.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired UserService userService;
    @Autowired DepartmentService departmentService;

    @RequestMapping("list")
    public String list(Model model) {
    	List<User> users=userService.findAll();
    	
        model.addAttribute("users", users);
      
  
     
        return "user/list";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("userRegister", new UserRegister());
        model.addAttribute("departments", departmentService.findAll());
        return "user/register";
    }
    @PostMapping("register")
    public String register(Model model,
            @Valid UserRegister userRegister, BindingResult bindingResult)
    {
        if (userService.hasErrors(userRegister, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            return "user/register";
        }
        userService.insert(userRegister);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model ,@RequestParam("id") int id) {
    
    	
    	model.addAttribute("userRegister", new UserRegister());
        model.addAttribute("departments", departmentService.findAll());
        return "user/edit";
    }
    @PostMapping("edit")
    public String edit(Model model,
            @Valid UserRegister userRegister, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentService.findAll());
            return "user/edit";
        }
        User user = userService.findByUserid(userRegister.getUserid());
        if (user != null) {
            bindingResult.rejectValue("userid", null, "사용자 아이디가 중복됩니다.");
            model.addAttribute("departments", departmentService.findAll());
            return "user/edit";
        }
        userService.insert(userRegister);
        return "redirect:list";
    }

  
}
