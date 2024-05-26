package com.internal.bms.hr.hrportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.service.JobPackageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/jobpackages")
@Validated
public class JobPackageController {

    @Autowired
    private JobPackageService jobPackageService;

    @PostMapping
    public ResponseEntity<JobPackage> createJobPackage(@Valid @RequestBody JobPackage jobPackage) {
        JobPackage createdJobPackage = jobPackageService.createJobPackage(jobPackage);
        return ResponseEntity.ok(createdJobPackage);
    }
}
