package com.cms.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.department.entity.Department;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Optional<Department> findByDepartmentCode(String departmentCode);
}
