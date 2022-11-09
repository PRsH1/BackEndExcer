package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student findOne(int id);

    @Select("SELECT * FROM student WHERE studentNumber = #{studentNumber}")
    Student findByStudentNumber(String studentNumber);

    List<Student> findAll();
    void insert(Student student);
    void update(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(int id);
}
