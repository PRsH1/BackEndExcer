package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Manager;
@Mapper
public interface ManagerMapper {
	@ResultMap("ManagerWithProject")
	
	@Select("SELECT p.*,m.name ,m.phone ,m.office from project p join manager m on p.managerId=m.id")
    List<Manager> findAll();

}
