package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping({"/", "index"})
    public String index() {
        return "home/index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @PostMapping("/login_processing")
    public String processLogin(@RequestParam String userid, @RequestParam String passwd) {
        // validate user credentials and redirect to appropriate page
        return "redirect:/";
    }
}
