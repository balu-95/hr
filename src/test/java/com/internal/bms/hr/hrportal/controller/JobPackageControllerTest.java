package com.internal.bms.hr.hrportal.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.service.JobPackageService;

@WebMvcTest(JobPackageController.class)
class JobPackageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobPackageService jobPackageService;

    @Autowired
    private ObjectMapper objectMapper;

    private JobPackage jobPackage;

    @BeforeEach
    void setUp() {
        jobPackage = new JobPackage();
        jobPackage.setId(1L);
    }

    @Test
    void shouldCreateJobPackage() throws Exception {
        when(jobPackageService.createJobPackage(any(JobPackage.class))).thenReturn(jobPackage);

        mockMvc.perform(post("/api/v1/jobpackages")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(jobPackage)))
                .andExpect(status().isOk());
    }
}
