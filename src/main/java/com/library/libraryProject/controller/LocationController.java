package com.library.libraryProject.controller;

import com.library.libraryProject.model.Location;
import com.library.libraryProject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @PostMapping(value = "/addLocation")
    public Location addLocations(@RequestBody Location location) {

        return locationRepository.save(location);
    }


}
