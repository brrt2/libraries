package com.library.libraryProject.service;

import com.library.libraryProject.model.CustomUserDetails;
import com.library.libraryProject.model.User;
import com.library.libraryProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByName(username);

        optionalUser
                .orElseThrow(()->new UsernameNotFoundException("No such user found ! "));
        return optionalUser.map(CustomUserDetails::new).get();
    }
}
