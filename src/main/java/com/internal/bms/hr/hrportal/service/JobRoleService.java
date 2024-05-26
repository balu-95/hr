package com.internal.bms.hr.hrportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.repository.JobRoleRepository;

@Service
public class JobRoleService {
    @Autowired
    private JobRoleRepository jobRoleRepository;

    public List<JobRole> getAllJobRoles() {
        return jobRoleRepository.findAll();
    }

   
}
