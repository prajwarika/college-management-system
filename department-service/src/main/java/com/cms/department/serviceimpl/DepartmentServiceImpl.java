package com.cms.department.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cms.department.entity.Department;
import com.cms.department.exception.ResourceNotFoundException;
import com.cms.department.repository.DepartmentRepository;
import com.cms.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private final DepartmentRepository departmentRepo;
	
	public DepartmentServiceImpl(DepartmentRepository departmentRepo) {
		this.departmentRepo = departmentRepo;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentRepo.findAll();
		if (departments.isEmpty()) {
			throw new ResourceNotFoundException("No departments found!!");
		}
		return departments;
	}

	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepo.save(department);
	}

	@Override
    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found"));
    }

	@Override
	public Department getDepartmentByCode(String departmentCode) {
		// TODO Auto-generated method stub
		return departmentRepo.findByDepartmentCode(departmentCode)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found with code: " + departmentCode));
	}
	
}
