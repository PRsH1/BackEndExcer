package net.skhu.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.dto.Student;

@Controller
public class ExcerStudent {

    @GetMapping("form5/student")
    public String register1(Model model) {
        return "form5/student";
    }

    @PostMapping("form5/student")
    public String register1(Model model, HttpSession session, Student student)
    {
        String errorMsg = null;
        if (student.getStudentNo() == null || student.getStudentNo().length() == 0)
            errorMsg = "학번을 입력하세요";
        else if (student.getName() == null || student.getName().length() == 0)
            errorMsg = "이름을 입력하세요";
        else if (student.getEmail() == null || student.getEmail().length() == 0)
            errorMsg = "이메일 주소를 입력하세요";
        else if(student.getDepartmentId() =="0") {
        	errorMsg ="전공을 선택하세요";
        }
        else {
        	session.setAttribute("student", student);
            return "redirect:student_success";
        }
        model.addAttribute(student);
        model.addAttribute("errorMsg", errorMsg);
        return "form5/student";
    }

    @RequestMapping("form5/student_success")
    public String student_success(Model model) {
        return "form5/student_success";
    }



}
