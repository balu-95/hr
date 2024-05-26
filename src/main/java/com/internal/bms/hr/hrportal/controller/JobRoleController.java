package com.internal.bms.hr.hrportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.service.JobRoleService;

@RestController
@RequestMapping("/api/v1/job-roles")
public class JobRoleController {

	private final JobRoleService jobRoleService;

	public JobRoleController(JobRoleService jobRoleService) {
		super();
		this.jobRoleService = jobRoleService;
	}

	@GetMapping
	public ResponseEntity<List<JobRole>> getAllJobRoles() {

		List<JobRole> jobRoles = jobRoleService.getAllJobRoles();
		return new ResponseEntity<>(jobRoles, HttpStatus.OK);

	}
}
