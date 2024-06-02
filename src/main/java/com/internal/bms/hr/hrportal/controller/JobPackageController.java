package com.internal.bms.hr.hrportal.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.service.JobPackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/jobpackages")
@Validated
public class JobPackageController {

	private final JobPackageService jobPackageService;

	public JobPackageController(JobPackageService jobPackageService) {
		super();
		this.jobPackageService = jobPackageService;
	}

	@PostMapping
	public ResponseEntity<JobPackage> createJobPackage(@Valid @RequestBody JobPackage jobPackage) {
		JobPackage createdJobPackage = jobPackageService.createJobPackage(jobPackage);
		return new ResponseEntity<>(createdJobPackage, HttpStatus.CREATED);	}
}
