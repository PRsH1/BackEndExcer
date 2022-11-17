package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Book;

@Mapper
public interface BookCategoryMapper {

    @Select("SELECT * FROM category")
    List<Book> findAll();

}
