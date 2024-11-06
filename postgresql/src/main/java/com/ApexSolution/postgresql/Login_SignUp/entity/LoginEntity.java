package com.ApexSolution.postgresql.Login_SignUp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Accounts")
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "username_ID")
    private Integer usernameID;

    @Column(name = "user_Password", nullable = false)
    private String userPassword;

    @Column(name = "user_Email", nullable = false, unique = true)
    private String userEmail;

    public enum UserRole {
        Technician,Client
    }

    @Column(name = "user_Role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "token")
    private String token;

    public LoginEntity(String userEmail, String token) {
    }

    public LoginEntity() {
    }

    public LoginEntity(String userPassword, String userEmail, UserRole userRole) {
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userRole = userRole;
    }

    // Getters and setters

    public Integer getUsernameID() {
        return usernameID;
    }

    public void setUsernameID(Integer usernameID) {
        this.usernameID = usernameID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
