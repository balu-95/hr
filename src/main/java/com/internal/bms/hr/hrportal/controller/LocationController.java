package com.internal.bms.hr.hrportal.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.service.LocationService;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {
	private final LocationService locationService;

	public LocationController(LocationService locationService) {
		super();
		this.locationService = locationService;
	}

	@GetMapping
	public ResponseEntity<List<Location>> getAllLocations() {
		List<Location> locations = locationService.getAllLocations();
		return new ResponseEntity<>(locations, HttpStatus.OK);
	}
}
