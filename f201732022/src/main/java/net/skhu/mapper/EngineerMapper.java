package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Engineer;


@Mapper
public interface EngineerMapper {

    @Select("SELECT * FROM engineer WHERE id = #{id}")
    Engineer findOne(int id);

    @Select("SELECT * FROM engineer WHERE employeeNo = #{employeeNo}")
    Engineer findByEmpolyeeNo(String employeeNo);

    @Select("SELECT e.*,r.title from engineer e join role r on e.roleId=r.id order by e.id")
    List<Engineer> findAll();
 
    @Insert("INSERT engineer (employeeNo,name,roleId,phone,sex,email) VALUES (#{employeeNo}, #{name}, #{roleId}, #{phone}, #{sex}, #{email})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Engineer engineer);
   
    @Update(" UPDATE engineer SET employeeNo = #{employeeNo}, name = #{name}, roleId = #{roleId}, sex = #{sex}, email = #{email}, phone=#{phone}  WHERE id = #{id}")
    void update(Engineer engineer);

    @Delete("DELETE FROM engineer WHERE roleId = #{roleId}")
    void delete1(int roleId);
    
    @Delete("DELETE FROM engineer WHERE roleId = #{roleId}")
    void deleteRoleid(int roleId);
    
    @Delete("DELETE FROM engineer WHERE id = #{id}")
    void delete(int id);
}
