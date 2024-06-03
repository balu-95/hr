package com.internal.bms.hr.hrportal.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.internal.bms.hr.hrportal.entity.JobRole;
import com.internal.bms.hr.hrportal.service.JobRoleService;

@WebMvcTest(JobRoleController.class)
class JobRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobRoleService jobRoleService;

    private List<JobRole> jobRoles;

    @BeforeEach
    void setUp() {
        JobRole jobRole1 = new JobRole();
        jobRole1.setId(1L);
        jobRole1.setName("Role1");

        JobRole jobRole2 = new JobRole();
        jobRole2.setId(2L);
        jobRole2.setName("Role2");

        jobRoles = Arrays.asList(jobRole1, jobRole2);
    }

    @Test
    @WithMockUser(username = "testuser", password = "testpass", roles = "USER")
    void shouldGetAllJobRoles() throws Exception {
        when(jobRoleService.getAllJobRoles()).thenReturn(jobRoles);

        mockMvc.perform(get("/api/v1/job-roles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Role1"))
                .andExpect(jsonPath("$[1].name").value("Role2"));
    }
}
