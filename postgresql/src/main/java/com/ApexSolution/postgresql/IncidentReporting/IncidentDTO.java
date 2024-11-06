package com.ApexSolution.postgresql.IncidentReporting;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class IncidentDTO {
    //For the jobs ic
    private Integer job_id;

    //For the technicians_id
    private Integer tech_id;

    //For the Incident Alterations
    private Integer incident_id;
    private String incident_status;
    private String incident_priority;
    private LocalDateTime incident_time;
    private String description;

}
