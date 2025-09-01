package com.example.security_service.service;

import com.example.security_service.client.UserClient;
import com.example.security_service.dto.MyUserPrincipal;
import com.example.security_service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String email) throws RuntimeException {
        UserDTO user = userClient.getEmail(email);

        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("User Name Not Found");
        }
        return new MyUserPrincipal(user);
    }
}
