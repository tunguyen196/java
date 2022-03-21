package com.security.services;

import com.security.models.User;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    private final int active = 1;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User userModel = userRepository.findByUsername(username);
        boolean lockAccount = true;

        if (userModel == null) {
            throw new UsernameNotFoundException(username);
        }

        if(userModel.getStatus() == this.active) lockAccount = false;

        UserDetails user = org.springframework.security.core.userdetails.User.withUsername(userModel.getUsername())
                .password(userModel.getPassword())
                .authorities("ROLE_" + userModel.getStatus())
                .accountLocked(lockAccount)
                .build();

        return user;

    }
}
