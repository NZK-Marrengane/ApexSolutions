package com.ApexSolution.postgresql.Report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.event.RepositoryEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/job/{job_id}")
    public ResponseEntity<reportDTO> createReport(@PathVariable Integer job_id){
        reportDTO report = reportService.createJobReport(job_id);
        return ResponseEntity.ok(report);
    }
}
