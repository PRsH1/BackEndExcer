package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import net.skhu.dto.User;
import net.skhu.model.Pagination;

@Mapper
public interface UserMapper {

    @Select("""
       select u.*, d.name departmentName from user u left join department d on u.departmentId=d.id order by u.id LIMIT #{firstRecordIndex}, #{sz} """)
    List<User> findAll(Pagination pagination);
    //#{firstRecordIndex} 부분에 채워지는 값은, pagination.getFirstRecordIndex() 메소드의 리턴값
    //#{sz} 부분에 채워지는 값은, pagination.getSz() 메소드의 리턴값

    @Select("SELECT COUNT(id) FROM user")
    int getCount();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User findOne(int id);

    @Insert("""
        INSERT user (userid, password, name, enabled, userType, email,departmentId)
        VALUES (#{userid}, #{password}, #{name}, #{enabled}, #{userType}, #{email},#{departmentId}) """)
    void insert(User user);

    @Update("""
        UPDATE user SET
          userid = #{userid},
          password = #{password},
          name = #{name},
          departmentId = #{departmentId},
          enabled= #{enabled},
          userType = #{userType},
          email = #{email}  WHERE id = #{id} """)
    void update(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteById(int id);
}
