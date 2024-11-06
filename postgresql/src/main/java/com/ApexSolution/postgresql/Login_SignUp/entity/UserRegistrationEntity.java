package com.ApexSolution.postgresql.Login_SignUp.entity;

public class UserRegistrationEntity {

    private LoginEntity loginEntity;
    private ClientEntity clientEntity;

    // Getters and setters
    public LoginEntity getLoginEntity() { return loginEntity; }
    public void setLoginEntity(LoginEntity loginEntity) { this.loginEntity = loginEntity; }

    public ClientEntity getClientEntity() { return clientEntity; }
    public void setClientEntity(ClientEntity clientEntity) { this.clientEntity = clientEntity; }
}
