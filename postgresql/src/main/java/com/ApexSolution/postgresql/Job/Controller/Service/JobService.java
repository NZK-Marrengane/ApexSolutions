package com.ApexSolution.postgresql.Job.Controller.Service;

import com.ApexSolution.postgresql.DataAccess.Entity.*;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.*;
import com.ApexSolution.postgresql.Job.Controller.DTO.clientName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ClientRepository clientRepository;

    public Job createJob(Client client, String description) {
        // Get max Job ID number
        Integer maxJobId = jobRepository.findMaxJobId();
        int newJobId = (maxJobId != null) ? maxJobId + 1 : 1;

        // Get max Incident ID number
        Integer maxIncidentId = incidentRepository.findMaxIncidentId();
        int newIncidentId = (maxIncidentId != null) ? maxIncidentId + 1 : 1;

        //Get max report ID number
        Integer maxReportId = reportRepository.findMaxReportId();
        int newReportId = (maxReportId != null) ? maxReportId + 1 : 1;

        // Create new Incident
        Incident incident = new Incident();
        incident.setIncident_id(newIncidentId);
        incident.setIncident_status("");
        incident.setIncident_priority("");
        incident.setIncident_time(LocalDateTime.now());
        incident.setDescription("");
        incidentRepository.save(incident);

        // Retrieve the technician with tech_id = 0 (default technician)
        Technician defaultTechnician = technicianRepository.findById(0)
                .orElseThrow(() -> new RuntimeException("Default technician with ID 0 not found"));

        // Create for report
        Report report = new Report();
        report.setReport_id(newReportId);
        report.setReport_type("Client Report");
        report.setData_source("Monitoring Tools");
        report.setGenerated_by("System");
        reportRepository.save(report);

        // Create new Job
        Job job = new Job();
        job.setJob_id(newJobId);
        job.setJob_date(LocalDate.now());
        job.setClient(client);
        job.setIncident(incident);
        job.setReport(report);
        job.setTechnician(defaultTechnician); // Assign default technician with tech_id = 0
        job.setDescription(description);
        job.setJob_status(JobStatus.PENDING);

        return jobRepository.save(job);
    }

    // Assign technician to a job, updating tech_id
    public Job assignTechnicianToJob(Integer jobId, Technician technician) {
        Job job = jobRepository.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found"));
        job.setTechnician(technician);  // This will set tech_id to the technician's ID
        job.setJob_status(JobStatus.IN_PROGRESS);
        return jobRepository.save(job);
    }

    // Get jobs with no technician assigned (tech_id is 0)
    public List<Job> getAvailableJobs() {
        return jobRepository.findUnassignedJobs();
    }

    public clientName getClient(Integer client_id){
        Client client = clientRepository.findById(client_id).orElseThrow(() -> new RuntimeException("Client Not Found"));
        clientName clientName = new clientName();

        clientName.setName(client.getClient_name());
        clientName.setSurname(client.getClient_surname());

        return clientName;
    }
}
