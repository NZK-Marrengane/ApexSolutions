package com.ApexSolution.postgresql.DataAccess.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "jobs")
public class Job {

    @Id
    private Integer job_id;

    private LocalDate job_date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "incident_id", referencedColumnName = "incident_id")
    private Incident incident;

    @ManyToOne
    @JoinColumn(name = "report_id", referencedColumnName = "report_id")
    private Report report;

    // Many-to-One relationship to Technician, nullable
    @ManyToOne(optional = true)
    @JoinColumn(name = "tech_id", referencedColumnName = "tech_id", nullable = true)
    private Technician technician;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "job_status", nullable = false)
    private JobStatus job_status = JobStatus.PENDING;

}
