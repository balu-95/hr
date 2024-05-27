package com.internal.bms.hr.hrportal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.repository.JobRoleRepository;

class JobRoleServiceTest {

    @Mock
    private JobRoleRepository jobRoleRepository;

    @InjectMocks
    private JobRoleService jobRoleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllJobRoles() {
        // Arrange
        JobRole jobRole1 = new JobRole();
        jobRole1.setId(1L);
        jobRole1.setName("Role1");

        JobRole jobRole2 = new JobRole();
        jobRole2.setId(2L);
        jobRole2.setName("Role2");

        List<JobRole> expectedJobRoles = Arrays.asList(jobRole1, jobRole2);

        when(jobRoleRepository.findAll()).thenReturn(expectedJobRoles);

        // Act
        List<JobRole> actualJobRoles = jobRoleService.getAllJobRoles();

        // Assert
        assertEquals(expectedJobRoles.size(), actualJobRoles.size());
        assertEquals(expectedJobRoles.get(0).getName(), actualJobRoles.get(0).getName());
        assertEquals(expectedJobRoles.get(1).getName(), actualJobRoles.get(1).getName());
    }
}
