package net.skhu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Book;

import net.skhu.mapper.BookMapper;

@Controller

public class BookController {

    @Autowired BookMapper bookMapper;

    @RequestMapping("book/list")
    public String list(Model model) {
        model.addAttribute("books", bookMapper.findAll());
        return "book/list";

    }
    @RequestMapping("book/list1")
    public String list1(Model model, String srchText) {
        if (srchText == null) srchText = "";
        else {
        	model.addAttribute("book", bookMapper.findById(Integer.parseInt(srchText)));
        	return "book/detail";
        }

        model.addAttribute("books", bookMapper.findByName(srchText+ "%"));
        model.addAttribute("srchText", srchText);
        System.out.print(srchText);
        return "book/list1";
    }
    @RequestMapping("book/detail")
    public String detail(Model model, Integer id) {
        if (id == null) id = 2;
        model.addAttribute("book", bookMapper.findById(id));
        return "book/detail";
    }
    @RequestMapping("book/list2")
    public String list2(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("books", bookMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "book/list2";
    }
    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/detail";
    }

    @PostMapping("create")
    public String create(Model model, Book book) {
        bookMapper.insert(book);
        return "redirect:list2";
    }
    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Book book = bookMapper.findById(id);
        model.addAttribute("book", book);
        return "book/detail";
    }

    @PostMapping("edit")
    public String edit(Model model, Book book) {
        bookMapper.update(book);
        return "redirect:list2";
    }









}
