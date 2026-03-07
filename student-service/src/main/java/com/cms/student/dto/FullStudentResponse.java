package com.cms.student.dto;

import com.cms.student.entity.Student;

public class FullStudentResponse {
    private Student student;
    private DepartmentDTO department;

    public FullStudentResponse() {}
    public FullStudentResponse(Student student, DepartmentDTO department) {
        this.student = student;
        this.department = department;
    }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public DepartmentDTO getDepartment() { return department; }
    public void setDepartment(DepartmentDTO department) { this.department = department; }
}