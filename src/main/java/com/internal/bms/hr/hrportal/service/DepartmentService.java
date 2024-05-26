package com.internal.bms.hr.hrportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.Department;
import com.internal.bms.hr.hrportal.repository.DepartmentRepository;

@Service
public class DepartmentService {
	private final DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

}
