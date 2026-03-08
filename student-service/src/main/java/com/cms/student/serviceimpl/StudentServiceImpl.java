package com.cms.student.serviceimpl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cms.student.entity.Student;
import com.cms.student.exception.ResourceNotFoundException;
import com.cms.student.repository.StudentRepository;
import com.cms.student.service.StudentService;
import com.cms.student.feign.DepartmentClient; // Added Import
import com.cms.student.dto.DepartmentDTO;     // Added Import
import com.cms.student.dto.FullStudentResponse; // Added Import

@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepo;
	private final DepartmentClient departmentClient;

	// SINGLE manual constructor for both dependencies
	public StudentServiceImpl(StudentRepository studentRepo, DepartmentClient departmentClient) {
		this.studentRepo = studentRepo;
		this.departmentClient = departmentClient;
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
	    List<Student> students = studentRepo.findAll();
	    if (students.isEmpty()) {
	        throw new ResourceNotFoundException("No students found in the record.");
	    }
	    return students;
	}

	@Override
	public FullStudentResponse getStudentWithDepartment(Long studentId) {
	    // 1. Fetch Student from MySQL
	    Student student = studentRepo.findById(studentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

	    // 2. Fetch Department from Department-Service via Feign
	    DepartmentDTO department = departmentClient.getDepartment(student.getDepartmentId());

	    // 3. Combine and Return
	    return new FullStudentResponse(student, department);
	}

	@Override
	public Student getStudentByRollNo(String rollNo) {
		// TODO Auto-generated method stub
		return studentRepo.findByRollNumber(rollNo).orElseThrow(() -> new ResourceNotFoundException("Student Not Found!!"));
	}
}