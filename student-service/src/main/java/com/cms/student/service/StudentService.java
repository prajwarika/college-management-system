package com.cms.student.service;

import java.util.List;

import com.cms.student.dto.FullStudentResponse;
import com.cms.student.entity.Student;

public interface StudentService {

	Student saveStudent(Student student);
	List<Student> getAllStudents();
	FullStudentResponse getStudentWithDepartment(Long studentId);
	Student getStudentByRollNo(String rollNo);
}
