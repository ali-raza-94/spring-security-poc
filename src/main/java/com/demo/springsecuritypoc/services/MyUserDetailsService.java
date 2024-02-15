package com.demo.springsecuritypoc.services;

import com.demo.springsecuritypoc.entities.MyUserDetails;
import com.demo.springsecuritypoc.entities.User;
import com.demo.springsecuritypoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.userRepository.findByUsernameAndEnabledIsTrue(username).orElseThrow(()->new UsernameNotFoundException("user not found"));;
        return new MyUserDetails(user);
    }
}
