package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import net.skhu.dto.Movie;
@Mapper
public interface Moviemapper {
	 @Select("select m.*,g.genreName from movie m join genre g on m.genreid=g.id where m.director like #{director}")
	    List<Movie> findByName(String director);
	 @Select("select m.*,g.genreName from movie m join genre g on m.genreid=g.id where m.id=#{id}")
	    Movie findById(int id);

}
