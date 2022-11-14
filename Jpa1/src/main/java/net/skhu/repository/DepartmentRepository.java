package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>  {

}
//Integer 이 부분은 primary key의 타입임