package com.internal.bms.hr.hrportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.bms.hr.hrportal.entity.JobRole;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Long> {

}
