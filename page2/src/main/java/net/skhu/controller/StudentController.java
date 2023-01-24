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
import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired DepartmentMapper departmentMapper;
    @Autowired StudentMapper studentMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        model.addAttribute("students", studentMapper.findByDepartmentId(pagination));
        pagination.setRecordCount(studentMapper.getCount(pagination));
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/list";
    }

    /**
   * List<Student> students = studentMapper.findByDepartmentId(pagination);
   pagination 객체의 di 속성값이 0 이면 전체 학생을 조회하고,
   pagination 객체의 di 속성값이 0 이 아니면 그 학과 학생만 조회한다.
   model.addAttribute("departments", departmentRepository.findAll());
  	조회 조건인 학과 목록을 select 태그로 출력하기 위해, 전체 학과 목록을 조회한다.


     * @param model
     * @param pagination
     * @return
     */
    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "student/edit";
        }
        studentMapper.insert(student);
        pagination.setDi(0);
        double temp = (double)studentMapper.getCount(pagination) / pagination.getSz();
        int lastPage = (int)Math.ceil(temp);//전체 학생 목록에서 마지막 페이지 번호를 구한다.
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();//리다이렉트 메타 태그 출력
    }
    /**
     * 학생등 등록한 후,
	전체 학생 목록에서 마지막 페이지로 리다이렉트 한다.

	pagination.setDi(0);
  	전체 학생 목록을 조회하기 위해서 di 값을 0으로 설정한다.

     
     */

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        model.addAttribute("student", studentMapper.findOne(id));
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Pagination pagination,
            @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("departments", departmentMapper.findAll());
            return "student/edit";
        }
        studentMapper.update(student);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        studentMapper.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}
