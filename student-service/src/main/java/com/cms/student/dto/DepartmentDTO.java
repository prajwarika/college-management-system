package com.cms.student.dto;

public class DepartmentDTO {
    private Long id;
    private String departmentName;
    private String departmentCode;
    private int capacity;

    // Standard Constructors
    public DepartmentDTO() {}
    public DepartmentDTO(Long id, String departmentName, String departmentCode, int capacity) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.capacity = capacity;
    }

    // Manual Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getDepartmentCode() { return departmentCode; }
    public void setDepartmentCode(String departmentCode) { this.departmentCode = departmentCode; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}