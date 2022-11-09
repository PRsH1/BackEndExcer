package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Register;

@Mapper
public interface RegisterMapper {

    @ResultMap("RegisterWithStudentAndCourse")
    //  RegisterMapper.xml 파일의 id="RegisterWithStudentAndCourse" resultMap 방법조회 결과를 Java 객체들에 채워서 리턴한다.
    @Select("SELECT r.*, s.studentNumber, s.name studentName, c.courseName, c.unit " +
            " FROM register r JOIN student s ON r.studentId = s.id                 " +
            "                 JOIN course c ON r.courseId = c.id                   " +
            " ORDER BY s.studentNumber                                             ")
    //SQL명령문 XML파일에 써도 됨
    List<Register> findAll();

}
