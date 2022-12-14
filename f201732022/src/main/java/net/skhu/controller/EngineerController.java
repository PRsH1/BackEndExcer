package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Engineer;
import net.skhu.dto.Role;
import net.skhu.mapper.EngineerMapper;
import net.skhu.mapper.RoleMapper;


@Controller
public class EngineerController {

    @Autowired EngineerMapper mapper;
    @Autowired RoleMapper roleMapper;

    @RequestMapping("engineer/list")
    public String list(Model model) {
        model.addAttribute("engineers", mapper.findAll());
        return "engineer/list";
    }
    @GetMapping("engineer/create")
    public String create1(Model model,Engineer engineer) {
       
        List<Engineer> engineers = mapper.findAll();
        List<Role> role = roleMapper.findAll();        
        model.addAttribute("engineers", engineers);
        model.addAttribute("role", role);
        return "engineer/edit";
    }

    @PostMapping("engineer/create")
    public String create(Model model, Engineer engineer) {
        mapper.insert(engineer);
        return "redirect:list";
    }

    @GetMapping("engineer/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Engineer engineer = mapper.findOne(id);
        List<Role> role = roleMapper.findAll();
        model.addAttribute("engineer", engineer);
        model.addAttribute("role",role);
       
        return "engineer/edit";
    }

    @PostMapping("engineer/edit")
    public String edit(Model model, Engineer engineer) {
        mapper.update(engineer);
        return "redirect:list";
    }

    @RequestMapping("engineer/delete")
    public String delete(Model model, @RequestParam("id") int id) {
    
		mapper.deleteRoleid(id);
        mapper.delete(id);
        return "redirect:list";
    }

}
