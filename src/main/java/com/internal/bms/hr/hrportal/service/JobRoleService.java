package com.internal.bms.hr.hrportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.repository.JobRoleRepository;

@Service
public class JobRoleService {

	private final JobRoleRepository jobRoleRepository;

	public JobRoleService(JobRoleRepository jobRoleRepository) {
		super();
		this.jobRoleRepository = jobRoleRepository;
	}

	public List<JobRole> getAllJobRoles() {
		return jobRoleRepository.findAll();
	}

}
