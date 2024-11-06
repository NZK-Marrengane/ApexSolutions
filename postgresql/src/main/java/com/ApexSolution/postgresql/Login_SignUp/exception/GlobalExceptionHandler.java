package com.ApexSolution.postgresql.Login_SignUp.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<String> handlerInvalidFormat(InvalidFormatException ex){

        // returning custom response when a JSON parse error occurs
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role");
    }
}
