package com.cms.student.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.student.dto.FullStudentResponse;
import com.cms.student.entity.Student;
import com.cms.student.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@Valid @RequestBody Student student) {
		Student savedStudent = studentService.saveStudent(student);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<FullStudentResponse> getFullStudentDetails(@PathVariable Long id) {
	    return ResponseEntity.ok(studentService.getStudentWithDepartment(id));
	}
}
