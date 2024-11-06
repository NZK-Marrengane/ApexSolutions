package com.ApexSolution.postgresql.Login_SignUp.repository;


import com.ApexSolution.postgresql.Login_SignUp.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
    Optional<LoginEntity> findByUserEmailAndUserPassword(String userEmail, String userPassword);
    Optional<LoginEntity> findByUserEmail(String userEmail);
    Optional<LoginEntity> findByToken(String token);
}

