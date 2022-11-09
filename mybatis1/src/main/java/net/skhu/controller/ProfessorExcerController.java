package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.ProfessorEx;
import net.skhu.mapper.ProfessorExMapper;

@Controller
@RequestMapping("professor")
public class ProfessorExcerController {

    @Autowired ProfessorExMapper mapper;

    @RequestMapping("listEx")
    public String list(Model model) {
        List<ProfessorEx> professors = mapper.findAll();
        model.addAttribute("professors", professors);
        return "professor/listEx";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("professor", new ProfessorEx());
        return "professor/proEdit";
    }

    @PostMapping("create")
    public String create(Model model, ProfessorEx professor) {
        mapper.insert(professor);
        return "redirect:listEx";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        ProfessorEx professor = mapper.findOne(id);
        model.addAttribute("professor", professor);
        return "professor/proEdit";
    }

    @PostMapping("edit")
    public String edit(Model model, ProfessorEx professor) {
        mapper.update(professor);
        return "redirect:listEx";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        mapper.delete(id);
        return "redirect:listEx";
    }
}
