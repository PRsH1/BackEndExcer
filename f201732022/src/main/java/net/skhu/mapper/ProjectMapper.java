package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Manager;
@Mapper
public interface ProjectMapper {

	
	@Select("SELECT m.* ,p.title,p.progress,p.priority from manager m join project p on m.id=p.managerId")
    List<Manager> findAll();

}
