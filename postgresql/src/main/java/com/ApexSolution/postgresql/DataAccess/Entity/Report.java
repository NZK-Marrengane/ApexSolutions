package com.ApexSolution.postgresql.DataAccess.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {

    @Id
    private Integer report_id;

    private String report_type;

    private String data_source;
    private String generated_by;
}
