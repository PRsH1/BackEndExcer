package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Role;
import net.skhu.entity.Manager;
import net.skhu.entity.Engineer;
import net.skhu.repository.EngineerRepository;
import net.skhu.repository.ManagerRepository;
import net.skhu.repository.RoleRepository;

@Controller
/*@RestController 
 * RestController 사용 시 list.jsp 동작 안함
 * */
@RequestMapping("engineer")
public class EngineerController {

    @Autowired EngineerRepository repo;
    @Autowired ManagerRepository maRepo;
    @Autowired RoleRepository roleRepo;

    @RequestMapping("test1")
    public List<Object[]> test1() {
        return repo.findEngineer();
    }
    
    @RequestMapping("test2")
    public List<Engineer> test2() {
        return repo.findByRoleId(1);
    }
    @RequestMapping("test3")
    public List<Manager> test3() {
        return maRepo.findByManagerAndProject("쇼핑몰오픈");
    }

    @RequestMapping("list")
    public String list(Model model) {
        List<Engineer> engineer = repo.findAll();
        model.addAttribute("engineers", engineer);
        return "engineer/list";
    }
    
    @RequestMapping("list2")
    public String list2(Model model) {
        List<Engineer> engineer = repo.findByRoleTitle("프론트엔드개발자","남");
        model.addAttribute("engineers", engineer);
        return "engineer/list2";
    }
    @RequestMapping("list3")
    public String list3(Model model) {
        List<Engineer> engineer = repo.findByAssignments();
        model.addAttribute("engineers", engineer);
        return "engineer/list3";
    }
    @RequestMapping("list4")
    public String list4(Model model) {
        List<Manager> manager=maRepo.findByProjectAndManager();
        model.addAttribute("managers", manager);
        return "engineer/list4";
    }

    @GetMapping("create")
    public String create(Model model) {
        Engineer engineer = new Engineer();
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("engineer", engineer);
        model.addAttribute("roles", roles);
        return "engineer/edit";
    }

    @PostMapping("create")
    public String create(Model model, Engineer engineer) {
        repo.save(engineer);
        return "redirect:list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
    	Engineer engineer = repo.findById(id).get();
        List<Role> roles = roleRepo.findAll();
        model.addAttribute("engineer", engineer);
        model.addAttribute("roles", roles);
        return "engineer/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Engineer engineer) {
    	repo.save(engineer);
        return "redirect:list";
    }
    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
    	repo.deleteById(id);
        return "redirect:list";
    }

   

}
