package com.internal.bms.hr.hrportal.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.bms.hr.hrportal.entity.JobOpening;

@Repository
public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {
	

}
