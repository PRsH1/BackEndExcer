package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.entity.Jumoon;



public interface JumoonRepository extends JpaRepository<Jumoon, Integer>  {


	@Query("SELECT j from Jumoon j  WHERE j.customer.name=?1")
	List<Jumoon> findByCustomerName(String name);

	@Query("SELECT j from Jumoon j  WHERE j.customer.salesman.name=?1")
	List<Jumoon> findBySalesmanName(String name);
    
  
}
