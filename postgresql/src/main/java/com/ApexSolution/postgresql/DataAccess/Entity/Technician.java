package com.ApexSolution.postgresql.DataAccess.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Setter
@Getter
@Entity
@Table(name = "technicians")
public class Technician {

    @Id
    private Integer tech_id;

    private String tech_Name;
    private String tech_skills;
    private Boolean tech_available;
    private String tech_location;
}
