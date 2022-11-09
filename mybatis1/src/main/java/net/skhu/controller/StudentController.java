package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.StudentMapper;

@Controller
public class StudentController {

    @Autowired StudentMapper studentMapper;

    @RequestMapping("student/list")
    public String list(Model model) {
        model.addAttribute("students", studentMapper.findAll());
        return "student/list";

    }
    @RequestMapping("student/list1")
    public String list1(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list1";
    }
    @RequestMapping("student/detail")
    public String detail(Model model, Integer id) {
        if (id == null) id = 5;
        //int 자료형으로도 넣을 수 있지만 이 경우 null값을 넣을 수 없어서
        //객체형 Integer로 선언하였다.
        model.addAttribute("student", studentMapper.findById(id));
        //null 에러가 나는 경우는 . 왼쪽 즉 객체가 null일 경우에 에러가 남 오른쪽은 null이더라도 nullerror가 나지 않음
        return "student/detail";
    }
    @RequestMapping("student/test")
    public String test(Model model) {
        return "student/test";
    }
    @RequestMapping("student/list2")
    public String list2(Model model, String srchText) {
        if (srchText == null) srchText = "";
        model.addAttribute("students", studentMapper.findByName(srchText + "%"));
        model.addAttribute("srchText", srchText);
        return "student/list2";
    }





}
