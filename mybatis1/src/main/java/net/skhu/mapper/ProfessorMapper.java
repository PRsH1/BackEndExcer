package net.skhu.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Professor;


@Mapper

public interface ProfessorMapper {

	 @Select("select p.*,l.title,l.year,l.semester,l.room,l.professorId from professor p join lecture l on p.id=l.professorId")
	    List<Professor> findAll();
	 @Select("select p.*,l.title,l.year,l.semester,l.room,l.professorId from professor p join lecture l on p.id=l.professorId where p.name like #{name} ")
	    List<Professor> findByName(String name);

}
