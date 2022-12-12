package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import net.skhu.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>  {


	List<Product> findByTitleStartsWith(String title);
	
	List<Product> findByCategory_TitleStartsWith(String title);
	@Query("SELECT p from Product p  WHERE p.category.title=?1")
	List<Product> findByCategoryStartsWith(String title);


	
    
  
}
