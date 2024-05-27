package com.internal.bms.hr.hrportal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.internal.bms.hr.hrportal.entity.Department;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.exception.ResourceNotFoundException;
import com.internal.bms.hr.hrportal.repository.DepartmentRepository;
import com.internal.bms.hr.hrportal.repository.JobPackageRepository;
import com.internal.bms.hr.hrportal.repository.JobRoleRepository;
import com.internal.bms.hr.hrportal.repository.LocationRepository;

class JobPackageServiceTest {

    private JobPackageService jobPackageService;
    private JobPackageRepository jobPackageRepository;
    private JobRoleRepository jobRoleRepository;
    private DepartmentRepository departmentRepository;
    private LocationRepository locationRepository;

    @BeforeEach
    void setUp() {
        jobPackageRepository = mock(JobPackageRepository.class);
        jobRoleRepository = mock(JobRoleRepository.class);
        departmentRepository = mock(DepartmentRepository.class);
        locationRepository = mock(LocationRepository.class);
        jobPackageService = new JobPackageService(jobPackageRepository, jobRoleRepository, departmentRepository, locationRepository);
    }

    @Test
    void testCreateJobPackage_WithValidEntities() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        JobRole jobRole = new JobRole();
        jobRole.setId(1L);
        Department department = new Department();
        department.setId(1L);
        Location location = new Location();
        location.setId(1L);
        jobPackage.setRole(jobRole);
        jobPackage.setDepartment(department);
        jobPackage.setLocation(location);
        jobPackage.setId(1L); // Setting the ID to 1L

        when(jobRoleRepository.findById(1L)).thenReturn(java.util.Optional.of(jobRole));
        when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.of(department));
        when(locationRepository.findById(1L)).thenReturn(java.util.Optional.of(location));
        when(jobPackageRepository.save(jobPackage)).thenReturn(jobPackage);

        // Act
        JobPackage createdJobPackage = jobPackageService.createJobPackage(jobPackage);

        // Assert
        assertNotNull(createdJobPackage);
        assertNotNull(createdJobPackage.getId());
        assertEquals(1L, createdJobPackage.getId());
        assertEquals(jobRole, createdJobPackage.getRole());
        assertEquals(department, createdJobPackage.getDepartment());
        assertEquals(location, createdJobPackage.getLocation());
    }


    @Test
    void testCreateJobPackage_WithInvalidJobRole() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        JobRole jobRole = new JobRole();
        jobRole.setId(1L);
        Department department = new Department();
        department.setId(1L);
        Location location = new Location();
        location.setId(1L);
        jobPackage.setRole(jobRole);
        jobPackage.setDepartment(department);
        jobPackage.setLocation(location);

        // Mock the repositories to throw ResourceNotFoundException
        when(jobRoleRepository.findById(1L)).thenThrow(ResourceNotFoundException.class);
        when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.of(department));
        when(locationRepository.findById(1L)).thenReturn(java.util.Optional.of(location));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> jobPackageService.createJobPackage(jobPackage));
    }

    @Test
    void testCreateJobPackage_WithInvalidDepartment() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        JobRole jobRole = new JobRole();
        jobRole.setId(1L);
        Department department = new Department();
        department.setId(1L);
        Location location = new Location();
        location.setId(1L);
        jobPackage.setRole(jobRole);
        jobPackage.setDepartment(department);
        jobPackage.setLocation(location);

        // Mock the repositories to throw ResourceNotFoundException
        when(jobRoleRepository.findById(1L)).thenReturn(java.util.Optional.of(jobRole));
        when(departmentRepository.findById(1L)).thenThrow(ResourceNotFoundException.class);
        when(locationRepository.findById(1L)).thenReturn(java.util.Optional.of(location));

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> jobPackageService.createJobPackage(jobPackage));
    }

    @Test
    void testCreateJobPackage_WithInvalidLocation() {
        // Arrange
        JobPackage jobPackage = new JobPackage();
        JobRole jobRole = new JobRole();
        jobRole.setId(1L);
        Department department = new Department();
        department.setId(1L);
        Location location = new Location();
        location.setId(1L);
        jobPackage.setRole(jobRole);
        jobPackage.setDepartment(department);
        jobPackage.setLocation(location);

        // Mock the repositories to throw ResourceNotFoundException
        when(jobRoleRepository.findById(1L)).thenReturn(java.util.Optional.of(jobRole));
        when(departmentRepository.findById(1L)).thenReturn(java.util.Optional.of(department));
        when(locationRepository.findById(1L)).thenThrow(ResourceNotFoundException.class);

        // Act and Assert
        assertThrows(ResourceNotFoundException.class, () -> jobPackageService.createJobPackage(jobPackage));
    }
}
