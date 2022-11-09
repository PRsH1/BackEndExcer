package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.ProfessorEx;

@Mapper
public interface ProfessorExMapper {

    @Select("select p.*,d.* from professor P join department d on p.departmentId=d.id")
    List<ProfessorEx> findAll();
    

    @Select("SELECT * FROM professor WHERE id = #{id}")
    ProfessorEx findOne(int id);

    @Insert("INSERT professor (professorName) VALUES (#{professorName})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(ProfessorEx professor);
	
    @Update("UPDATE professor SET professorName = #{professortName} WHERE id = #{id}")
    void update(ProfessorEx professor);

    @Delete("DELETE FROM professor WHERE id = #{id}")
    void delete(int id);
}
