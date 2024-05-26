package com.internal.bms.hr.hrportal.service;

import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.Department;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.exception.ResourceNotFoundException;
import com.internal.bms.hr.hrportal.repository.DepartmentRepository;
import com.internal.bms.hr.hrportal.repository.JobPackageRepository;
import com.internal.bms.hr.hrportal.repository.JobRoleRepository;
import com.internal.bms.hr.hrportal.repository.LocationRepository;

@Service
public class JobPackageService {

	private final JobPackageRepository jobPackageRepository;
	private final JobRoleRepository jobRoleRepository;
	private final DepartmentRepository departmentRepository;
	private final LocationRepository locationRepository;

	public JobPackageService(JobPackageRepository jobPackageRepository, JobRoleRepository jobRoleRepository,
			DepartmentRepository departmentRepository, LocationRepository locationRepository) {
		this.jobPackageRepository = jobPackageRepository;
		this.jobRoleRepository = jobRoleRepository;
		this.departmentRepository = departmentRepository;
		this.locationRepository = locationRepository;
	}

	public JobPackage createJobPackage(JobPackage jobPackage) {
		validateJobPackageEntities(jobPackage);

		// Save the job package after validation
		return jobPackageRepository.save(jobPackage);
	}

	private void validateJobPackageEntities(JobPackage jobPackage) {
		// Validate JobRole existence
		JobRole jobRole = jobRoleRepository.findById(jobPackage.getRole().getId()).orElseThrow(
				() -> new ResourceNotFoundException("JobRole not found with id: " + jobPackage.getRole().getId()));
		jobPackage.setRole(jobRole);

		// Validate Department existence
		Department department = departmentRepository.findById(jobPackage.getDepartment().getId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Department not found with id: " + jobPackage.getDepartment().getId()));
		jobPackage.setDepartment(department);

		// Validate Location existence
		Location location = locationRepository.findById(jobPackage.getLocation().getId()).orElseThrow(
				() -> new ResourceNotFoundException("Location not found with id: " + jobPackage.getLocation().getId()));
		jobPackage.setLocation(location);
	}
}
