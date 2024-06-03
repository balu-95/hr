package com.internal.bms.hr.hrportal.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.service.JobOpeningService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/job-openings")
@Validated
public class JobOpeningController {

	private final JobOpeningService jobOpeningService;

	public JobOpeningController(JobOpeningService jobOpeningService) {
		super();
		this.jobOpeningService = jobOpeningService;
	}

	@PostMapping
	public ResponseEntity<JobOpening> createJobOpening(@Valid @RequestBody JobOpening jobOpening) {
		JobOpening createdJobOpening = jobOpeningService.createJobOpening(jobOpening);
		return new ResponseEntity<>(createdJobOpening, HttpStatus.CREATED);
	}
	
    @GetMapping
    public ResponseEntity<Page<JobOpening>> getAllJobOpenings(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<JobOpening> jobOpeningsPage = jobOpeningService.getAllJobOpenings(PageRequest.of(page, size));
        return ResponseEntity.ok(jobOpeningsPage);
    }
    
    


}
