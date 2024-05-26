package com.internal.bms.hr.hrportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.internal.bms.hr.hrportal.entity.Location;
import com.internal.bms.hr.hrportal.repository.LocationRepository;

@Service
public class LocationService {

	final private LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

}
