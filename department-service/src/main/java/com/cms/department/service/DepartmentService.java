package com.cms.department.service;

import java.util.List;

import com.cms.department.entity.Department;

public interface DepartmentService {

	List<Department> getAllDepartments();
	Department saveDepartment(Department department);
	Department getDepartmentById(Long id);
	Department getDepartmentByCode(String departmentCode);
}
