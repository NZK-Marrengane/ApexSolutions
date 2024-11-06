package com.ApexSolution.postgresql.DataAccess.Entity.Repository;

import com.ApexSolution.postgresql.DataAccess.Entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}
