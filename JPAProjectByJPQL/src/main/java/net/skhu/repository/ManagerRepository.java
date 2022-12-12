package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import net.skhu.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>  {

	@Query("SELECT m FROM Manager m JOIN m.projects p WHERE p.title = ?1")
	List<Manager> findByManagerAndProject(String title);

	
	@Query("SELECT m,p FROM Manager m JOIN m.projects p")
	List<Manager> findByProjectAndManager();


}
