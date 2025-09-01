package com.example.security_service.controllerAdviser;

import com.example.security_service.dto.ErrorModel;
import com.example.security_service.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlAdviser {
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorModel> cityNotFoundException (UserNotFound ex) {
        ErrorModel errorModel = new ErrorModel(ex.getMessage());
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }
}
