package com.ApexSolution.postgresql.DataAccess.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    private Integer incident_id;

    private String incident_status;
    private String incident_priority;
    private LocalDateTime incident_time;
    private String description;

    @ManyToOne
    @JoinColumn(name = "job_id", referencedColumnName = "job_id")
    private Job job; // Link the incident to a job
}
