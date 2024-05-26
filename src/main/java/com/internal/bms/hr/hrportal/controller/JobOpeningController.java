package com.internal.bms.hr.hrportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.service.JobOpeningService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/job-openings")
@Validated
public class JobOpeningController {
    @Autowired
    private JobOpeningService jobOpeningService;

    @PostMapping
    public ResponseEntity<JobOpening> createJobOpening(@Valid @RequestBody JobOpening jobOpening) {
    	System.out.println("job opening test........");
        JobOpening createdJobOpening = jobOpeningService.createJobOpening(jobOpening);
        return new ResponseEntity<>(createdJobOpening, HttpStatus.CREATED);
    }
}