package net.skhu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE loginName = #{loginName}")
    User findByLoginName(String loginName);
}
