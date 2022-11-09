package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Book;



@Controller
public class BookController {

    @GetMapping("Excercise/book")
    public String bookString(Model model) {
        return "Excercise/book";
    }


    @PostMapping("Excercise/book")
    public String bookString(Model model, HttpSession session, Book book)
    {
        String errorMsg = null;
        if (book.getTitle() == null || book.getTitle().length()==0)
            errorMsg = "제목을 입력하세요";
        else if (book.getName() == null || book.getName().length() == 0)
            errorMsg = "저자를 입력하세요";
        else if (book.getBookMaker() == null || book.getBookMaker().length() == 0)
            errorMsg = "출판사를 입력하세요";
        else if (book.getValue()==0) {
        	errorMsg = "종류를 선택하세요!";
        }

        else {
            session.setAttribute("book", book);
            return "redirect:book_success";
        }
        model.addAttribute("book", book);
        model.addAttribute("errorMsg", errorMsg);
        return "Excercise/book";
    }

    @RequestMapping("Excercise/book_success")
    public String book_success(Model model) {

        return "Excercise/book_success";
    }

}
