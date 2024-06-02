package com.internal.bms.hr.hrportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.bms.hr.hrportal.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}