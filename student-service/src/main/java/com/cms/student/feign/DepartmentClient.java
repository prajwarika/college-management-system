package com.cms.student.feign;

import com.cms.student.dto.DepartmentDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {
    // Change this from "/department/{id}" to just "/{id}" 
    // if your DepartmentController has @RequestMapping("/department")
    @GetMapping("/department/id/{id}") 
    DepartmentDTO getDepartment(@PathVariable("id") Long id);
}