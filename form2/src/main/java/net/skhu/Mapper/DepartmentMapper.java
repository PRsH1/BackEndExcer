package net.skhu.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Department;

@Mapper
public interface DepartmentMapper {

    @Select("SELECT * FROM department")
    List<Department> findAll();
}
