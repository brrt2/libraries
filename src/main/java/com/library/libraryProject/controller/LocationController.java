package com.library.libraryProject.controller;

import com.library.libraryProject.model.Location;
import com.library.libraryProject.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping(value = "/allLocations")
    public Page<Location> getAllLocations(Pageable pageable) {
       return locationRepository.findAll();
    }

    @PostMapping(value = "/addLocation")
    public Location addLocations(@Valid @RequestBody Location location) {

        return locationRepository.save(location);
    }

    @GetMapping("/getbyid/{id}")
    public Location getLocationById(@PathVariable(value = "id") Long locationId) {
        return locationRepository.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException(" Did not find id " + String.valueOf(locationId)));
    }

    @PutMapping("/update/{id}")
    public Location updateLocation(@PathVariable(value = "id") Long locationId,
                           @Valid @RequestBody Location locationDetails) {

        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException("Did not find id "+String.valueOf(locationId)));

        location.setName(locationDetails.getName());
        location.setAddress(locationDetails.getAddress());

        Location updatedLocation = locationRepository.save(location);
        return updatedLocation;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new NoSuchElementException("Did not find id "+String.valueOf(locationId)));

        locationRepository.delete(location);

        return ResponseEntity.ok().build();
    }


}
