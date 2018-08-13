package com.springmvc.demo.bo.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
  
//    @Autowired
//    private IUserService service;
  
    @Autowired
    private MessageSource messages;
  
    @Autowired
    private RoleRepository roleRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String email)
      throws UsernameNotFoundException {
  
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new org.springframework.security.core.userdetails.User(
              " ", " ", true, true, true, true, 
              getAuthorities(Arrays.asList(
                roleRepository.findByName("ROLE_USER"))));
        }
 
        return new org.springframework.security.core.userdetails.User(
          user.getEmail(), user.getPassword(), user.isEnabled(), true, true, 
          true, getAuthorities(user.getRoles()));
    }
 
    private Collection<? extends GrantedAuthority> getAuthorities(
      Collection<Role> roles) {
  
        return getGrantedAuthorities(getPrivileges(roles));
    }
 
    private List<String> getPrivileges(Collection<Role> roles) {
  
        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }
 
    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
    
//    public User registerNewUserAccount(UserDto accountDto) throws EmailExistsException {
        public User registerNewUserAccount(UserDTO accountDto)  {
//        if (emailExist(accountDto.getEmail())) {
//            throw new EmailExistsException(
//              "There is an account with that email adress:" + accountDto.getEmail());
//        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
         
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
         
        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
        return userRepository.save(user);
    }
    
}