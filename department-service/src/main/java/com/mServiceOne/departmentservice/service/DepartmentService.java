package com.mServiceOne.departmentservice.service;

import com.mServiceOne.departmentservice.entity.Department;
import com.mServiceOne.departmentservice.reporsitory.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment method of DepartmentService {\n");
        return departmentRepository.save(department);

    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById method of DepartmentService {\n");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
