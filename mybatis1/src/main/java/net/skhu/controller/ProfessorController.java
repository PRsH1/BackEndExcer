package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.ProfessorMapper;


@Controller

public class ProfessorController {

	@Autowired ProfessorMapper mapper;
	@RequestMapping("professor/list")
	public String list(Model model) {
		model.addAttribute("professor", mapper.findAll());
		return "professor/list";

	}
	@RequestMapping("professor/list1")
	public String list1(Model model,String search,String err) {
		if (search == null) search = "";
		if (model.addAttribute("professor", mapper.findByName(search + "%")) == null) {
			err="조회된 결과가 없습니다!";
			System.out.print(err);
			model.addAttribute("error",err);
		}
		else {
			model.addAttribute("professor", mapper.findByName(search + "%"));
			model.addAttribute("search", search);
		}
        return "professor/list1";

	}


}
