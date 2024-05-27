package com.internal.bms.hr.hrportal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.exception.ResourceNotFoundException;
import com.internal.bms.hr.hrportal.repository.JobOpeningRepository;
import com.internal.bms.hr.hrportal.repository.JobPackageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JobOpeningServiceTest {

    private JobOpeningService jobOpeningService;
    private JobOpeningRepository jobOpeningRepository;
    private JobPackageRepository jobPackageRepository;

    @BeforeEach
    void setUp() {
        jobOpeningRepository = mock(JobOpeningRepository.class);
        jobPackageRepository = mock(JobPackageRepository.class);
        jobOpeningService = new JobOpeningService(jobOpeningRepository, jobPackageRepository);
    }

    @Test
    void testCreateJobOpening_WithValidJobPackage() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        jobPackage.setId(1L);

        JobOpening jobOpening = new JobOpening();
        jobOpening.setJobPackage(jobPackage);

        when(jobPackageRepository.findById(1L)).thenReturn(java.util.Optional.of(jobPackage));
        when(jobOpeningRepository.save(jobOpening)).thenReturn(jobOpening);

        // Act
        JobOpening createdJobOpening = jobOpeningService.createJobOpening(jobOpening);

        // Assert
        assertEquals(jobPackage, createdJobOpening.getJobPackage());
    }

    @Test
    void testCreateJobOpening_WithNullJobPackage() {
        // Arrange
        JobOpening jobOpening = new JobOpening();
        jobOpening.setJobPackage(null);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> jobOpeningService.createJobOpening(jobOpening));
    }

    @Test
    void testCreateJobOpening_WithInvalidJobPackage() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        jobPackage.setId(1L);

        JobOpening jobOpening = new JobOpening();
        jobOpening.setJobPackage(jobPackage);

        when(jobPackageRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> jobOpeningService.createJobOpening(jobOpening));
    }
}
