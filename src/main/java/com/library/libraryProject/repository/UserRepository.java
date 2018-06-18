package com.library.libraryProject.repository;

import com.library.libraryProject.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {
    Optional<User> findByName(String username);
}
