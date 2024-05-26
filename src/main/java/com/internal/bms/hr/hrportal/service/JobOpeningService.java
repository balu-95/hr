package com.internal.bms.hr.hrportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.exception.ResourceNotFoundException;
import com.internal.bms.hr.hrportal.repository.JobOpeningRepository;
import com.internal.bms.hr.hrportal.repository.JobPackageRepository;

@Service
public class JobOpeningService {
    @Autowired
    private JobOpeningRepository jobOpeningRepository;
    @Autowired
    private JobPackageRepository jobPackageRepository;

    public JobOpening createJobOpening(JobOpening jobOpening) {
        // Validate JobPackage existence
        JobPackage jobPackage = jobOpening.getJobPackage();
        if (jobPackage == null) {
            throw new IllegalArgumentException("JobPackage must be provided.");
        }

        Long jobPackageId = jobPackage.getId();
        if (jobPackageId == null) {
            throw new IllegalArgumentException("JobPackage ID must be provided.");
        }

        JobPackage existingJobPackage = jobPackageRepository.findById(jobPackageId)
                .orElseThrow(() -> new ResourceNotFoundException("JobPackage not found with id: " + jobPackageId));

        jobOpening.setJobPackage(existingJobPackage);
        return jobOpeningRepository.save(jobOpening);
    }
}
