package com.ApexSolution.postgresql.Login_SignUp.controller;


import com.ApexSolution.postgresql.Login_SignUp.entity.ClientEntity;
import com.ApexSolution.postgresql.Login_SignUp.entity.EmailResponseEntity;
import com.ApexSolution.postgresql.Login_SignUp.entity.LoginEntity;
import com.ApexSolution.postgresql.Login_SignUp.entity.UserRegistrationEntity;
import com.ApexSolution.postgresql.Login_SignUp.service.EmailService;
import com.ApexSolution.postgresql.Login_SignUp.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final LoginService loginService;
    private final EmailService emailService;

    public AuthenticationController(LoginService loginService, EmailService emailService) {
        this.loginService = loginService;
        this.emailService = emailService;
    }

    // Method to check if the user role is valid
    private boolean isValidUserRole(LoginEntity.UserRole role) {
        if (role == null) {
            return false; // Handles null issues
        }
        return EnumSet.allOf(LoginEntity.UserRole.class).contains(role);
    }

    // 1. Login API
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginEntity loginEntity) {

        // Check if there is a user with matching email and password, ignoring the user role
        Optional<LoginEntity> user = loginService.findByUserEmailAndPassword(loginEntity.getUserEmail(), loginEntity.getUserPassword());

        if (user.isPresent()) {
            // Check if the role matches
            LoginEntity.UserRole storedUserRole = user.get().getUserRole();
            LoginEntity.UserRole inputUserRole = loginEntity.getUserRole();

            // If roles don't match, return default response
            if (!storedUserRole.equals(inputUserRole)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access restricted.");
            }

            // Validate the input user role against the enum values
            if (!isValidUserRole(inputUserRole)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid role.");
            }

            // Proceed with switch case if roles match
            return switch (storedUserRole) {
                case Client -> ResponseEntity.ok("Login successful!\n\nWelcome to the Client portal!");
                case Technician -> ResponseEntity.ok("Login successful!\n\nWelcome to the Technician portal!");
            };

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    // 2. Signup API
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationEntity userRegistration) {

        LoginEntity loginEntity = userRegistration.getLoginEntity();
        ClientEntity clientEntity = userRegistration.getClientEntity();

        Optional<LoginEntity> existingUser = loginService.findByUserEmail(loginEntity.getUserEmail());

        if (existingUser.isPresent()) {
            return ResponseEntity.badRequest().body("User already registered");
        }

        loginService.saveRegister(clientEntity);
        loginService.saveLogin(loginEntity);

        return ResponseEntity.ok("User registered successfully!");
    }

    // 3. Forgot Password - Request Reset Link
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody EmailResponseEntity emailResponseEntity) {

        Optional<LoginEntity> user = loginService.findByUserEmail(emailResponseEntity.getUserEmail());

        if (user.isPresent()) {

            LoginEntity loginEntity = user.get();
            String token = UUID.randomUUID().toString();

            // Set and save token in the user's record
            loginEntity.setToken(token);
            loginService.saveLogin(loginEntity);

            // Send email with user's email and generated token
            EmailResponseEntity emailResponse = emailService.sendPasswordResetEmail(loginEntity.getUserEmail(), token);
            return ResponseEntity.ok("Password reset link sent to your email:\n\n" + emailResponse.toString());

        } else {
            return ResponseEntity.status(404).body("Email not found");
        }
    }

    // 4. Reset Password
    @PutMapping("/reset-password")
    public ResponseEntity<String> resetUserPassword(@RequestBody LoginEntity loginEntity) {
        Optional<LoginEntity> validToken = loginService.findByToken(loginEntity.getToken());

        if (validToken.isPresent()) {

            LoginEntity user = validToken.get();
            user.setUserPassword(loginEntity.getUserPassword());
            loginService.saveLogin(user);  // Save the updated user with the new password

            return ResponseEntity.ok("Password reset successful");

        } else {
            return ResponseEntity.status(401).body("Invalid or expired token");
        }
    }

}
