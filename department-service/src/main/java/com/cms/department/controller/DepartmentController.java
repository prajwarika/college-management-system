package com.cms.department.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.department.entity.Department;
import com.cms.department.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private final DepartmentService departmentService;
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepartments() {
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}
	
	@PostMapping("/register")
	public ResponseEntity<Department> registerDepartment(@Valid @RequestBody Department department) {
		return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}
	
	@GetMapping("/code/{departmentCode}")
	public ResponseEntity<Department> getDepartmentByCode(@PathVariable String departmentCode) {
		return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
	}
}
