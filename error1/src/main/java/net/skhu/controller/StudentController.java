package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Slf4j
/**
 * 
 * @author LSH
 *이것은 lombok 어노테이션이다.
 이 어노테이션이 붙은 클래스에는 log 멤버 변수 객체가 자동으로 생성된다.
 즉 lombok이 StudentController 클래스에 log 멤버 변수 객체를 자동으로 생성해준다.
 관리자나 개발자가 봐야할 자세한 에러 메시지는 이 log 객체를 이용해서 출력해야 한다.

 */
@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("students", studentMapper.findAll(pagination));
        pagination.setRecordCount(studentMapper.getCount());
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors() == false) {
                studentMapper.insert(student);
                int lastPage = (int)Math.ceil((double)studentMapper.getCount() / pagination.getSz());
                pagination.setPg(lastPage);
                return "redirect:list?" + pagination.getQueryString();
                //정상적인 작업을 수행
            }
        } catch (Exception exception) {
            bindingResult.reject("error", "등록 실패");
            //<form:errors path="" class="red" /> 이 태그 부분에 메시지 출력
            log.error("등록 실패 {}", student, exception);
            //student 객체의 내부 속성값들이 {} 부분에 출력된다.
            //에러 시 사용자에게 메시지 출력
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        model.addAttribute("student", studentMapper.findOne(id));
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors() == false) {
                studentMapper.update(student);
                return "redirect:list?" + pagination.getQueryString();
            }
        } catch (Exception exception) {
            bindingResult.reject("error", "저장 실패");
            log.error("저장 실패 {}", student, exception);
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        try {
            studentMapper.deleteById(id);
            return "redirect:list?" + pagination.getQueryString();
        } catch (Exception exception) {
            bindingResult.reject("error", "삭제 실패");
            log.error("삭제 실패 {}", id, exception);
            //id 변수의 값이 {} 부분에 출력된다.
            /**
             * log.error("삭제 실패 {} {}", id, student, exception);
   			id 변수의 값이 {} 부분에, student 객체의 내부 속성값들이 {} 부분에 출력된다

             */
        }
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }
}
//모든 postMapping 메소드에 에러처리 구현함