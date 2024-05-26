package com.internal.bms.hr.hrportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internal.bms.hr.hrportal.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
