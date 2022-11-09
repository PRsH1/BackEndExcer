package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import net.skhu.dto.Book;




@Mapper
public interface BookMapper {

    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id")
    List<Book> findAll();
    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id where b.author like #{ name }")
    List<Book> findByName(String name);
    @Select("select b.*, c.categoryName from book b join category c on b.categoryId=c.id where b.id =#{id}")
    Book findById(int id);
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findOne(int id);
    @Insert("INSERT book (title) VALUES (#{title})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void insert(Book book);
    @Update("UPDATE book SET title = #{title} WHERE id = #{id}")
    void update(Book book);
}
