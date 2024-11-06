package com.ApexSolution.postgresql.DataAccess.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client {

    @Id
    private Integer client_id;

    private String client_name;
    private String client_surname;

}
