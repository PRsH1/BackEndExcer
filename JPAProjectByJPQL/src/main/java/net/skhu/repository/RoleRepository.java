package net.skhu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



import net.skhu.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>  {



}
