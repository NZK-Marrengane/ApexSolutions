package com.ApexSolution.postgresql.DataAccess.Entity.Repository;

import com.ApexSolution.postgresql.DataAccess.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
