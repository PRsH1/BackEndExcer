package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;


import net.skhu.dto.Project;
import net.skhu.dto.Manager;
import net.skhu.mapper.ManagerMapper;
import net.skhu.mapper.ProjectMapper;

@Controller
@RequestMapping("project")
public class ManagerController{

    @Autowired ManagerMapper mapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Manager> managers = mapper.findAll();
       
        model.addAttribute("managers", managers);
        return "project/list";
    }

 
}
