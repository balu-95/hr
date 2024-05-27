package com.internal.bms.hr.hrportal.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(LocationController.class)
public class LocationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocationService locationService;

    private List<Location> locations;

    @BeforeEach
    void setUp() {
        Location location1 = new Location();
        location1.setId(1L);
        location1.setName("Location1");

        Location location2 = new Location();
        location2.setId(2L);
        location2.setName("Location2");

        locations = Arrays.asList(location1, location2);
    }

    @Test
    void shouldGetAllLocations() throws Exception {
        when(locationService.getAllLocations()).thenReturn(locations);

        mockMvc.perform(get("/api/v1/locations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Location1"))
                .andExpect(jsonPath("$[1].name").value("Location2"));
    }
}
