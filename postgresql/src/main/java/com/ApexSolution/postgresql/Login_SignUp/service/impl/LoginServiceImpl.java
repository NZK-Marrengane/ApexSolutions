package com.ApexSolution.postgresql.Login_SignUp.service.impl;


import com.ApexSolution.postgresql.Login_SignUp.entity.ClientEntity;
import com.ApexSolution.postgresql.Login_SignUp.entity.LoginEntity;
import com.ApexSolution.postgresql.Login_SignUp.repository.LoginRepository;
import com.ApexSolution.postgresql.Login_SignUp.repository.SignupRepository;
import com.ApexSolution.postgresql.Login_SignUp.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;
    private final SignupRepository signupRepository;

    public LoginServiceImpl(LoginRepository loginRepository, SignupRepository signupRepository) {
        this.loginRepository = loginRepository;
        this.signupRepository = signupRepository;
    }

    @Override
    public Optional<LoginEntity> findByUserEmailAndPassword(String email, String password) {
        return loginRepository.findByUserEmailAndUserPassword(email, password);
    }

    @Override
    public Optional<LoginEntity> findByUserEmail(String email) {
        return loginRepository.findByUserEmail(email);
    }

    @Override
    public void saveLogin(LoginEntity loginEntity) {
        loginRepository.save(loginEntity);
    }

    @Override
    public void saveRegister(ClientEntity clientEntity) {signupRepository.save(clientEntity);
    }

    @Override
    public Optional<LoginEntity> findByToken(String token) {
        return loginRepository.findByToken(token);
    }
}
