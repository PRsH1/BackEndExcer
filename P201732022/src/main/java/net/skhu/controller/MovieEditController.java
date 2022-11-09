package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.MovieEdit;


@Controller

public class MovieEditController {

    @GetMapping("movie/edit")
    public String bookString(Model model) {
        return "movie/edit";
    }


    @PostMapping("movie/edit")
    public String bookString(Model model, HttpSession session, MovieEdit edit)
    {
        String errorMsg = null;
        if (edit.getDirector()==null || edit.getDirector().length()==0)
            errorMsg = "감독을 입력하세요";
        else if (edit.getTitle() == null || edit.getTitle().length() == 0)
            errorMsg = "제목를 입력하세요";
        else if (edit.getYear() == null || edit.getYear().length() == 0)
            errorMsg = "년도를 입력하세요";
        else if (edit.getCountry() == null || edit.getCountry().length() == 0)
            errorMsg = "국가를 입력하세요";



        else {
            model.addAttribute("edit",edit);
            return "redirect:edit_success";
        }
        model.addAttribute("edit",edit);
        model.addAttribute("errorMsg", errorMsg);
        return "movie/edit";
    }

    @RequestMapping("movie/edit_success")
    public String edit_success(Model model) {

        return "movie/edit_success";
    }

}

