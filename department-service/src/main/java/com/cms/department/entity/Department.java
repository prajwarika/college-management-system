package com.cms.department.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Department name is mandatory")
    private String departmentName;

    @NotBlank(message = "Department code is mandatory")
    private String departmentCode;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    // Default Constructor
    public Department() {}

    // Full Constructor
    public Department(Long id, String departmentName, String departmentCode, int capacity) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.capacity = capacity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}