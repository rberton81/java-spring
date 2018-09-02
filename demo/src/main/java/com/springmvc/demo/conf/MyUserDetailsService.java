package com.springmvc.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springmvc.demo.dto.UserDTO;
import com.springmvc.demo.dto.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
 
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDTO user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);
    }
}