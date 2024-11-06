package com.ApexSolution.postgresql.DataAccess.Entity.Repository;

import com.ApexSolution.postgresql.DataAccess.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    @Query("SELECT MAX(j.job_id) FROM Job j")
    Integer findMaxJobId();

    // Find jobs where no technician is assigned (tech_id is 0)
    @Query("SELECT j FROM Job j WHERE j.technician.tech_id = 0")
    List<Job> findUnassignedJobs();
}
