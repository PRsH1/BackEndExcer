package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.skhu.mapper.BookCategoryMapper;
import net.skhu.model.Bmodel;

@Controller
public class BookCategoryController {

    @Autowired
    BookCategoryMapper mapper;

    @ModelAttribute
    public void addSomething(Model model) {
        model.addAttribute("categoryies", mapper.findAll());
        //이 문장은 이 컨트롤러의 모든 메소드에서 작동한다
        
    }

    @GetMapping("category/edit1")
    public String edit1(Model model) {
        model.addAttribute("bmodel", new Bmodel());
        return "category/edit1";	
    }

    @PostMapping("category/edit1")
    public String edit1(Model model, Bmodel bmodel) {
    	
        return "category/edit1";
    }



}
