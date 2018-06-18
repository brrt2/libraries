package com.library.libraryProject.repository;

import com.library.libraryProject.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location,Long> {

    Location save(Location location);
    Page<Location> findAll();
    Location findByName(String name);
    Location findById(Long id);
}
