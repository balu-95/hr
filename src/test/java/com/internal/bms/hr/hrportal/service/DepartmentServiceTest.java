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

import com.internal.bms.hr.hrportal.entity.Department;
import com.internal.bms.hr.hrportal.repository.DepartmentRepository;

class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDepartments() {
        // Mocking the behavior of departmentRepository.findAll()
        Department department1 = new Department();
        department1.setId(1L);
        department1.setName("Department 1");

        Department department2 = new Department();
        department2.setId(2L);
        department2.setName("Department 2");

        List<Department> expectedDepartments = Arrays.asList(department1, department2);

        when(departmentRepository.findAll()).thenReturn(expectedDepartments);

        // Call the service method
        List<Department> actualDepartments = departmentService.getAllDepartments();

        // Assert that the returned list matches the expected list
        assertEquals(expectedDepartments.size(), actualDepartments.size());
        assertEquals(expectedDepartments.get(0).getId(), actualDepartments.get(0).getId());
        assertEquals(expectedDepartments.get(0).getName(), actualDepartments.get(0).getName());
        assertEquals(expectedDepartments.get(1).getId(), actualDepartments.get(1).getId());
        assertEquals(expectedDepartments.get(1).getName(), actualDepartments.get(1).getName());
    }
}
