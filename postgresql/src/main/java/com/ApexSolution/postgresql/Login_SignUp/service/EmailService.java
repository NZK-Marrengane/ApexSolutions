package com.ApexSolution.postgresql.Login_SignUp.service;


import com.ApexSolution.postgresql.Login_SignUp.entity.EmailResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public EmailResponseEntity sendPasswordResetEmail(String userEmail, String token) {
        System.out.println("userEmail: " + userEmail);
        System.out.println("token: " + token);

        String resetUrl = "http://localhost:8080/auth/reset-password";
        String subject = "Password Reset Request";
        String message = "Click the following link to reset your password: " + resetUrl;

        // Instead of sending the email to an email service platform (e.g. Gmail - for Google),
        // create and return an EmailResponse object
        return new EmailResponseEntity(userEmail, subject, message, token);
    }
}
