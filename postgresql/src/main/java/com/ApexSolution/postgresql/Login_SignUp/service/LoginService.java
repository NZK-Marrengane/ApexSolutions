package com.ApexSolution.postgresql.Login_SignUp.service;



import com.ApexSolution.postgresql.Login_SignUp.entity.ClientEntity;
import com.ApexSolution.postgresql.Login_SignUp.entity.LoginEntity;

import java.util.Optional;

public interface LoginService {
    Optional<LoginEntity> findByUserEmailAndPassword(String email, String password); // login

    Optional<LoginEntity> findByUserEmail(String email); //signup checking if the user exists in the database already

    void saveLogin(LoginEntity loginEntity); //signing up a new user

    void saveRegister(ClientEntity clientEntity); // for storing user information into the client table

    Optional<LoginEntity> findByToken(String token); //forgot password process
}
