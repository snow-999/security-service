package com.example.security_service.service;

import com.example.security_service.client.UserClient;
import com.example.security_service.dto.TokenModel;
import com.example.security_service.dto.UserDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private UserClient userClient;

    public TokenModel login(String email, HttpServletResponse response) {
        TokenModel model = new TokenModel();
        UserDTO userModel = userClient.getEmail(email);
        if (userModel.getName() == null  || userModel.getPass()== null) {
            throw new IllegalArgumentException("Please Enter Valid Inputs");
        }
        Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(userModel.getName(), userModel.getPass()));
        if (!authentication.isAuthenticated()) {
            throw new IllegalArgumentException();
        }
        TokenModel token = new TokenModel();
        token.setToken(jwtService.generateToken(userModel));
        jwtService.addJwtToCookie(token.getToken(),response);
        return model;
    }
}
