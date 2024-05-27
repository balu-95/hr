package com.internal.bms.hr.hrportal.service;

import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllLocations() {
        // Arrange
        Location location1 = new Location();
        location1.setId(1L);
        location1.setName("Location1");

        Location location2 = new Location();
        location2.setId(2L);
        location2.setName("Location2");

        List<Location> expectedLocations = Arrays.asList(location1, location2);

        when(locationRepository.findAll()).thenReturn(expectedLocations);

        // Act
        List<Location> actualLocations = locationService.getAllLocations();

        // Assert
        assertEquals(expectedLocations.size(), actualLocations.size());
        assertEquals(expectedLocations.get(0).getName(), actualLocations.get(0).getName());
        assertEquals(expectedLocations.get(1).getName(), actualLocations.get(1).getName());
    }
}
