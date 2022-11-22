package net.skhu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.dto.Department;
import net.skhu.dto.User;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.model.UserRegister;

@Service
public class DepartmentService {

	//Department mapper를  호출하는 서비스 클래스
    @Autowired
    public DepartmentMapper departmentMapper;

    public List<Department> findAll() {
        return departmentMapper.findAll();
    }
 


}
