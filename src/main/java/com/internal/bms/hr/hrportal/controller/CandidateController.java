package com.internal.bms.hr.hrportal.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.internal.bms.hr.hrportal.entity.Application;
import com.internal.bms.hr.hrportal.entity.ApplicationStatus;
import com.internal.bms.hr.hrportal.entity.Candidate;
import com.internal.bms.hr.hrportal.service.CandidateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Candidate", description = "Operations related to candidates")
@Validated
@RequestMapping("/api/v1/candidates")
public class CandidateController {

    private static final Logger logger = LoggerFactory.getLogger(CandidateController.class);

    private CandidateService candidateService;
    
    public CandidateController(CandidateService candidateService) {
    	this.candidateService=candidateService;
	}

    @Operation(summary = "Create a new candidate", description = "Creates a new candidate and optionally uploads a resume")
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Candidate> createCandidate(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam(required = false) String mobileNumber,
            @RequestParam(required = false) MultipartFile resume) throws IOException {

        logger.debug("Received candidate creation request: name={}, email={}, mobileNumber={}, resume={}", 
                name, email, mobileNumber, resume != null ? resume.getOriginalFilename() : "null");

        Candidate candidate = new Candidate();
        candidate.setName(name);
        candidate.setEmail(email);
        candidate.setMobileNumber(mobileNumber);

        if (resume != null && !resume.isEmpty()) {
            logger.debug("Resume file size: {}", resume.getSize());
            candidate.setResume(resume.getBytes());
        }

        Candidate savedCandidate = candidateService.saveCandidate(candidate);
        return ResponseEntity.ok(savedCandidate);
    }    
    
    @PostMapping("/{candidateId}/apply/{jobOpeningId}")
    public ResponseEntity<Application> applyForJob(@PathVariable Long candidateId, @PathVariable Long jobOpeningId) {
        Application application = candidateService.applyForJob(candidateId, jobOpeningId);
        return ResponseEntity.ok(application);
    }

    @GetMapping("/{candidateId}/applications")
    public ResponseEntity<List<ApplicationStatus>> getApplicationsByCandidate(
            @PathVariable Long candidateId) {
        List<ApplicationStatus> applicationStatusList = candidateService.getApplicationStatusByCandidateId(candidateId)
                .stream()
                .map(application -> new ApplicationStatus(application.getStatus()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(applicationStatusList);
    }

}
