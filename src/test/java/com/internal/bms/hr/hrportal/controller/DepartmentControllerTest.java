package com.internal.bms.hr.hrportal.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.internal.bms.hr.hrportal.entity.Department;
import com.internal.bms.hr.hrportal.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc; // Step 2: Use MockMvc for HTTP actions

    @MockBean
    private DepartmentService departmentService; // Step 3: Mock the DepartmentService

    @Test
    public void testGetAllDepartments() throws Exception {
        // Creating mock data
        Department department1 = new Department();
        department1.setId(1L);
        department1.setName("HR");

        Department department2 = new Department();
        department2.setId(2L);
        department2.setName("Finance");

        // Defining the behavior of the mocked service
        when(departmentService.getAllDepartments()).thenReturn(Arrays.asList(department1, department2));

        // Performing a GET request and verifying the response
        mockMvc.perform(get("/api/v1/departments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("HR"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Finance"));
    }
}
