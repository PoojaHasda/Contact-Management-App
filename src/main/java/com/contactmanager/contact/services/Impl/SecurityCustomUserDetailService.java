package com.contactmanager.contact.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// import com.contactmanager.contact.repositories.UserRepo;

@Service
public class SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private com.contactmanager.contact.repositories.UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // apne user ko load karana hai
        return userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email : " + username));

    }

}