package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;

@Controller
public class DepartmentController {

    @Autowired DepartmentMapper mapper;

    @RequestMapping("student/list")
    public String list(Model model) {
        model.addAttribute("departments", mapper.findAll());
        return "student/list";
    }
    @GetMapping("student/create")
    public String create(Model model) {
        Student student = new Student();
        List<Department> departments = mapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("student/create")
    public String create(Model model, Student student) {
        mapper.insert(student);
        return "redirect:list";
    }

    @GetMapping("student/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Student student = mapper.findOne(id);
        List<Department> departments = mapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @PostMapping("student/edit")
    public String edit(Model model, Student student) {
        mapper.update(student);
        return "redirect:list";
    }

    @RequestMapping("student/delete")
    public String delete(Model model, @RequestParam("id") int id) {
        mapper.delete(id);
        return "redirect:list";
    }

}
