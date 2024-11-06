package com.ApexSolution.postgresql.Report;

import com.ApexSolution.postgresql.DataAccess.Entity.Incident;
import com.ApexSolution.postgresql.DataAccess.Entity.Job;
import com.ApexSolution.postgresql.DataAccess.Entity.Report;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.JobRepository;
import com.ApexSolution.postgresql.DataAccess.Entity.Repository.ReportRepository;
import com.ApexSolution.postgresql.DataAccess.Entity.Technician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ReportService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ReportRepository repoRepository;

    public reportDTO createJobReport(Integer job_id){
        Job job = jobRepository.findById(job_id).orElseThrow(() -> new RuntimeException("Job not Found"));
        Technician technician = job.getTechnician();
        Incident incident = job.getIncident();
        Report report = job.getReport();

        //Populate the JobReportDTO
        reportDTO reportDTO = new reportDTO();

        //From job
        reportDTO.setJob_id(job_id);
        reportDTO.setJob_date(job.getJob_date());
        reportDTO.setIncident_id(job.getIncident().getIncident_id());
        reportDTO.setTech_id(job.getTechnician().getTech_id());
        reportDTO.setClient_id(job.getClient().getClient_id());
        reportDTO.setJob_description(job.getDescription());
        reportDTO.setStatus(job.getJob_status().toString());

        //From Technician
        reportDTO.setTech_name(technician.getTech_Name());
        reportDTO.setTech_location(technician.getTech_location());
        reportDTO.setTech_skills(technician.getTech_skills());
        reportDTO.setIncident_description(report.getReport_type());

        //From Report
        reportDTO.setReport_id(job.getReport().getReport_id());
        reportDTO.setReport_type(report.getReport_type());
        reportDTO.setData_source(report.getData_source());
        reportDTO.setGenerated_by(report.getGenerated_by());

        //From Incident
        reportDTO.setIncident_status(incident.getIncident_status());
        reportDTO.setIncident_time(incident.getIncident_time());
        reportDTO.setIncident_priority(incident.getIncident_priority());
        reportDTO.setIncident_description(incident.getDescription());
        return reportDTO;
    }
}
