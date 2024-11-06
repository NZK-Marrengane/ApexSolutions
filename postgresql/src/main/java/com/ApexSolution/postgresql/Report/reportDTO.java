package com.ApexSolution.postgresql.Report;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class reportDTO {

    //Fields from job table
    private Integer job_id;

    private LocalDate job_date;
    private Integer incident_id;
    private Integer tech_id;
    private Integer client_id;
    private String job_description;
    private String Status;

    //Fields from Incident Table
    private String incident_status;
    private String incident_priority;
    private LocalDateTime incident_time;
    private String incident_description;

    // Fields from Technician
    private String tech_name;
    private String tech_skills;
    private String tech_location;

    // Fields from Reports
    private Integer report_id;
    private String report_type;
    private String data_source;
    private String generated_by;
}
