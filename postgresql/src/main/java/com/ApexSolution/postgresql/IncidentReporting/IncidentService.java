package com.ApexSolution.postgresql.IncidentReporting;

import com.ApexSolution.postgresql.DataAccess.Entity.Incident;
import com.ApexSolution.postgresql.DataAccess.Entity.Job;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.IncidentRepository;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.JobRepository;
import com.ApexSolution.postgresql.IncidentReporting.IncidentDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private JobRepository jobRepository;

    @Transactional
    public Incident addOrUpdateIncident(IncidentDTO incidentDTO) {
        // Retrieve job by job_id
        Job job = jobRepository.findById(incidentDTO.getJob_id())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Retrieve the existing Incident from the Job
        Incident incident = job.getIncident();
        if (incident == null) {
            throw new RuntimeException("Incident not found for this Job");
        }

        // Update incident details
        incident.setIncident_status(incidentDTO.getIncident_status());
        incident.setIncident_priority(incidentDTO.getIncident_priority());
        incident.setIncident_time(LocalDateTime.now());
        incident.setDescription(incidentDTO.getDescription());

        // Explicitly save the incident to ensure it persists in the database
        return incidentRepository.save(incident);
    }
}
