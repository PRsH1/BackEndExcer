package net.skhu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Product;


@Controller
public class ProductController {

    @GetMapping("Excercise/product")
    public String productCase(Model model) {
        return "Excercise/product";
    }


    @PostMapping("Excercise/product")
    public String productCase(Model model, HttpSession session, Product product)
    {
        String errorMsg = null;
        if (product.getProduct() == null || product.getProduct().length()==0)
            errorMsg = "제품명을 입력하세요";
        else if (product.getCategory()== 0)
            errorMsg = "카테고리를 선택하세요";
        else if (product.getPrice()==null || product.getPrice().length() == 0)
            errorMsg = "가격을 입력하세요";
        else if(product.getQuantity()==null || product.getQuantity().length()==0)
        	errorMsg = "수량을 입력하세요";
        else {
            session.setAttribute("product", product);
            return "redirect:product_success";
        }
        model.addAttribute("product", product);
        model.addAttribute("errorMsg", errorMsg);
        return "Excercise/product";
    }

    @RequestMapping("Excercise/product_success")
    public String product_success(Model model) {

        return "Excercise/product_success";
    }

}
