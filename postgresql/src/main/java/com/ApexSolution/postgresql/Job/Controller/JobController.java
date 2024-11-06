package com.ApexSolution.postgresql.Job.Controller;

import com.ApexSolution.postgresql.Job.Controller.DTO.clientName;
import com.ApexSolution.postgresql.Job.Controller.DTO.jobRequest;
import com.ApexSolution.postgresql.Job.Controller.DTO.jobSelectRequest;
import com.ApexSolution.postgresql.DataAccess.Entity.Client;
import com.ApexSolution.postgresql.DataAccess.Entity.Job;
import com.ApexSolution.postgresql.DataAccess.Entity.Technician;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.ClientRepository;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.TechnicianRepository;
import com.ApexSolution.postgresql.Job.Controller.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    // Endpoint for client to create a job using @RequestBody
    @PostMapping("/createJob")
    public ResponseEntity<Job> createJob(@RequestBody jobRequest jobRequest) {
        // Fetch client by ID
        Client client = clientRepository.findById(jobRequest.getClient_id())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        // Create job with provided description
        Job job = jobService.createJob(client, jobRequest.getDescription());
        return ResponseEntity.ok(job);
    }

    // Endpoint for technician to select a job using @RequestBody
    @PostMapping("/selectJob")
    public ResponseEntity<Job> selectJob(@RequestBody jobSelectRequest jobSelectionRequest) {
        // Fetch technician by ID
        Technician technician = technicianRepository.findById(jobSelectionRequest.getTech_id())
                .orElseThrow(() -> new RuntimeException("Technician not found"));

        // Assign technician to job
        Job job = jobService.assignTechnicianToJob(jobSelectionRequest.getJob_id(), technician);
        return ResponseEntity.ok(job);
    }

    // Get all available jobs for technicians
    @GetMapping("/available")
    public List<Job> getAvailableJobs() {
        return jobService.getAvailableJobs();
    }

    //Get the clients info after logging in
    @GetMapping("/clientInfo/{client_id}")
    public ResponseEntity<clientName> getInfo(@PathVariable Integer client_id){
        clientName clientData = jobService.getClient(client_id);
        return ResponseEntity.ok(clientData);
    }
}
