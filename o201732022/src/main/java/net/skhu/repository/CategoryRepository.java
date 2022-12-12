package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.entity.Category;
import net.skhu.entity.Product;



public interface CategoryRepository extends JpaRepository<Category, Integer>  {




	List<Category> findByTitleStartsWith(String title);
	
	@Query("SELECT p,c from Category c join c.product p")
	List<Product> findByProduct();
	
	@Query("SELECT p,c from Category c join c.product p where c.title= :title")
	List<Product> findByCategoryStartsWith(String title);
  
	
}
