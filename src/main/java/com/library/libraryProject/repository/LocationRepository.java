package com.library.libraryProject.repository;

import com.library.libraryProject.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location,Long> {

    Location save(Location location);
    Page<Location> findAll();
    Location findByName(String name);
}
