package com.internal.bms.hr.hrportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.Application;
import com.internal.bms.hr.hrportal.entity.ApplicationStatus;
import com.internal.bms.hr.hrportal.entity.Candidate;
import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.repository.ApplicationRepository;
import com.internal.bms.hr.hrportal.repository.ApplicationStatusRepository;
import com.internal.bms.hr.hrportal.repository.CandidateRepository;
import com.internal.bms.hr.hrportal.repository.JobOpeningRepository;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ApplicationRepository applicationRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final ApplicationStatusRepository applicationStatusRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository,
                            ApplicationRepository applicationRepository,
                            JobOpeningRepository jobOpeningRepository,
                            ApplicationStatusRepository applicationStatusRepository) {
        this.candidateRepository = candidateRepository;
        this.applicationRepository = applicationRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.applicationStatusRepository = applicationStatusRepository;
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Application applyForJob(Long candidateId, Long jobOpeningId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        JobOpening jobOpening = jobOpeningRepository.findById(jobOpeningId)
                .orElseThrow(() -> new RuntimeException("Job opening not found"));
        Application application = new Application();
        application.setCandidate(candidate);
        application.setJobOpening(jobOpening);
        application.setStatus(fetchApplicationStatusByName("Applied"));
        return applicationRepository.save(application);
    }

    public List<ApplicationStatus> getApplicationStatusByCandidateId(Long candidateId) {
        List<Application> applications = applicationRepository.findByCandidateId(candidateId);
        return applications.stream()
                .map(Application::getStatus)
                .collect(Collectors.toUnmodifiableList()));
    }

    private ApplicationStatus fetchApplicationStatusByName(String statusName) {
        return applicationStatusRepository.findByName(statusName)
                .orElseThrow(() -> new RuntimeException("Application status not found with name: " + statusName));
    }
}
