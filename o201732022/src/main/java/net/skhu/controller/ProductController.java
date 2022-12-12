package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Category;
import net.skhu.entity.Jumoon;
import net.skhu.entity.Product;
import net.skhu.entity.Salesman;
import net.skhu.repository.CategoryRepository;
import net.skhu.repository.JumoonRepository;
import net.skhu.repository.ProductRepository;
import net.skhu.repository.SalesmanRepository;

@Controller



@RequestMapping("exam")
public class ProductController {

    @Autowired ProductRepository repo;
    @Autowired SalesmanRepository saleRepo;
    @Autowired JumoonRepository juRepo;
    @Autowired CategoryRepository cateRepo;
  



    @RequestMapping("list1")
    public String list(Model model) {
        List<Product> product = repo.findAll();
        model.addAttribute("products", product);
        return "exam/list1";
    }
    
    @PostMapping("list1")
    public String list1(Model model, String srchText) {
        if (srchText == null) srchText = "";
        
        List<Product> product = repo.findByTitleStartsWith(srchText);
        model.addAttribute("products", product);
        model.addAttribute("srchText", srchText);
        return "exam/list1";
    }
    
    @RequestMapping("list2")
    public String list2(Model model) {
    	
        List<Product> product = cateRepo.findByProduct();
        model.addAttribute("products", product);
        return "exam/list2";
    }
    
    @PostMapping("list2")
    public String list2(Model model, String srchText) {
        if (srchText == null) srchText = "";
        
        List<Product> product=repo.findByCategory_TitleStartsWith(srchText);
       
        model.addAttribute("products", product);
       
        model.addAttribute("srchText", srchText);
        return "exam/list2";
    }
    
    
    @RequestMapping("list3")
    public String list3(Model model) {
    	List<Jumoon> jumoon = juRepo.findAll();
        model.addAttribute("jumoons", jumoon);
        return "exam/list3";
    }
    
    @PostMapping("list3")
    public String list3(Model model, String srchText) {
        if (srchText == null) srchText = "";
        
        List<Jumoon> jumoon=juRepo.findByCustomerName(srchText);
       
        model.addAttribute("jumoons", jumoon);
       
        model.addAttribute("srchText", srchText);
        return "exam/list3";
    }
    
    
    @RequestMapping("list4")
    public String list4(Model model) {
        List<Jumoon> jumoon = juRepo.findAll();
        model.addAttribute("jumoons", jumoon);
        return "exam/list4";
    }
    
    @PostMapping("list4")
    public String list4(Model model, String srchText) {
        if (srchText == null) srchText = "";
        
        List<Jumoon> jumoon=juRepo.findBySalesmanName(srchText);
       
        model.addAttribute("jumoons", jumoon);
       
        model.addAttribute("srchText", srchText);
        return "exam/list4";
    }

    
  

   

}