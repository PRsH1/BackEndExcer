package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE loginName = #{loginName}")
    User findByLoginName(String loginName);

    @Select("SELECT * from user")
	List<User> findAll();

   
    @Insert("INSERT INTO User (loginName, password, name, email, enabled, userType) " +
            "VALUES (#{loginName}, #{password}, #{name}, #{email}, #{enabled}, #{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
    
    
    @Update("UPDATE user SET loginName = #{loginName}, password = #{password}, name = #{name}, email = #{email}, enabled = #{enabled}, userType = #{userType}, departmentId = #{departmentId} WHERE id = #{id}")
    User updateUser(User user);
    
    

}

