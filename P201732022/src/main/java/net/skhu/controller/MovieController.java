package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.Moviemapper;


@Controller

public class MovieController {

	@Autowired Moviemapper mapper;

	 @RequestMapping("movie/list1")
	    public String list1(Model model, String srchText) {
	        if (srchText == null) srchText = "";
	        model.addAttribute("movie", mapper.findByName(srchText + "%"));
	        model.addAttribute("srchText", srchText);
	        return "movie/list1";
	    }
	 @RequestMapping("movie/detail")
	    public String detail(Model model, Integer id) {
	        if (id == null) id = 5;

	        model.addAttribute("movie", mapper.findById(id));
	        return "movie/detail";
	    }

}
