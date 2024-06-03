package com.internal.bms.hr.hrportal.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internal.bms.hr.hrportal.entity.JobOpening;
import com.internal.bms.hr.hrportal.entity.JobPackage;
import com.internal.bms.hr.hrportal.service.JobOpeningService;

@SpringBootTest
@AutoConfigureMockMvc
class JobOpeningControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JobOpeningService jobOpeningService;

    @Autowired
    private ObjectMapper objectMapper;

    private JobOpening jobOpening;
    private JobPackage jobPackage;

    @BeforeEach
    void setUp() {
        jobPackage = new JobPackage();
        jobPackage.setId(1L);

        jobOpening = new JobOpening();
        jobOpening.setJobPackage(jobPackage);
        jobOpening.setCustomTitle("Test Title");
        jobOpening.setCustomDescription("Test Description");
        jobOpening.setCustomSalary("1000");
        jobOpening.setCustomBenefits("Test Benefits");
    }

//    @Test
    @WithMockUser
    void shouldCreateJobOpening() throws Exception {
        when(jobOpeningService.createJobOpening(any(JobOpening.class))).thenReturn(jobOpening);

        mockMvc.perform(post("/api/v1/job-openings")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(jobOpening)))
                
                .andExpect(status().isCreated());
  }
}
