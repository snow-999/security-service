package com.example.security_service.client;


import com.example.security_service.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "registry-service",url = "localhost:8080")
public interface UserClient {
    @GetMapping("getemail")
    UserDTO getEmail(@RequestBody String email);
}