package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import net.skhu.dto.User;

@Mapper
@Repository
public interface UserMapper {
	

    
    User findByLoginName(String loginName);

    
	List<User> findAll();

   
    int insertUser(User user);
    
    
   
    
    

}

