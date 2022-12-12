package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.skhu.entity.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer>  {

	@Query("SELECT e.employeeNo, e.name, e.role.id,e.phone,e.sex FROM Engineer e")
    List<Object[]> findEngineer();
    
    @Query("SELECT e from Engineer e where e.role.id=?1")
    List<Engineer> findByRoleId(int id);
    
    @Query("SELECT e from Engineer e WHERE e.role.title=?1 AND e.sex=?2 ORDER BY e.id")
    List<Engineer> findByRoleTitle(String title, String sex);
    
    @Query("SELECT e from Engineer e JOIN e.assignments a WHERE a.id=4 ORDER BY e.id")
    List<Engineer> findByAssignments();
    
    

	
    
    





}
