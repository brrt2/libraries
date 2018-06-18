package com.library.libraryProject.repository;

import com.library.libraryProject.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByName(String username);
}
