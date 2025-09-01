package com.example.security_service.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService  implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEntity user = userRepository.findByName(userName);
//        UserDTO model = userConverter.convertUserEntityToDTO(user);
//        if (user == null) {
//            System.out.println("User Not Found");
//            throw new UsernameNotFoundException("User Name Not Found");
//        }
//        return new MyUserPrincipal(model);
        return null;
    }
}
