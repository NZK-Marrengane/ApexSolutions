package com.ApexSolution.postgresql.DataAccess.Entity.Repository;

import com.ApexSolution.postgresql.DataAccess.Entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Integer> {

    @Query("SELECT MAX(i.incident_id) FROM Incident i")
    Integer findMaxIncidentId();

}
