package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import net.skhu.dto.Student;

@Mapper

public interface StudentMapper {

    @Select("SELECT s.*, d.departmentName FROM student s JOIN department d ON s.departmentId = d.id")
    List<Student> findAll();
    

    @Select("SELECT * FROM student WHERE studentNumber = #{studentNumber}")
    Student findOne(int studentNumber);

    @Insert("INSERT student (studentNumber,name,departmentId,year) VALUES (#{studentNumber},#{name},#{departmentId},#{year})")
    @Options(useGeneratedKeys=true, keyProperty="studentNumber")
    void insert(Student student);
	
    @Update("UPDATE student SET name = #{name} WHERE studentNumber = #{studentNumber}")
    void update(Student student);

    @Delete("DELETE FROM student WHERE studentNumber = #{studentNumber}")
    void delete(int studentNubmer);
}
