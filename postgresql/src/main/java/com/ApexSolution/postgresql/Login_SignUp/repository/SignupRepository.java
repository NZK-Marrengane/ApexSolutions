package com.ApexSolution.postgresql.Login_SignUp.repository;


import com.ApexSolution.postgresql.Login_SignUp.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignupRepository extends JpaRepository<ClientEntity, Integer> {
    
}
