package com.demo.springsecuritypoc.services;

import com.demo.springsecuritypoc.entities.Privilege;
import com.demo.springsecuritypoc.entities.Role;
import com.demo.springsecuritypoc.entities.User;
import com.demo.springsecuritypoc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service("userDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = this.userRepository.findByUsernameAndEnabledIsTrue(username).orElseThrow(()->new UsernameNotFoundException("user not found"));;
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), user.isEnabled(), true, true,
                true, getAuthorities(user.getRoles()));
    }
    private List<SimpleGrantedAuthority> getSimpleGrantedAuthorities(List<String> userPrivileges) {
        return userPrivileges.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        return getSimpleGrantedAuthorities(mergeRolesAndPrivileges(roles));
    }
    private List<String> mergeRolesAndPrivileges(Collection<Role> roles) {

        List<String> privileges = new ArrayList<>();
        List<Privilege> collection = new ArrayList<>();
        for (Role role : roles) {
            privileges.add(role.getName());
            collection.addAll(role.getPrivileges());
        }
        for (Privilege item : collection) {
            privileges.add(item.getName());
        }
        return privileges;
    }
}
