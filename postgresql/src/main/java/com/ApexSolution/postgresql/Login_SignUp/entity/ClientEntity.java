package com.ApexSolution.postgresql.Login_SignUp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_ID")
    private Integer clientID;

    @Column(name = "client_Name", nullable = false)
    private String clientName;

    @Column(name = "client_Surname", nullable = false)
    private String clientSurname;

    @Column(name = "client_DOB", nullable = false)
    private String clientDOB;

    @Column(name = "client_Gender", nullable = false)
    private Character clientGender;

    public ClientEntity() {
    }

    public ClientEntity(Integer clientID, String clientName, String clientSurname, String clientDOB, Character clientGender) {
        this.clientID = clientID;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientDOB = clientDOB;
        this.clientGender = clientGender;
    }

    // getters and setters

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getClientName() {return clientName;}

    public void setClientName(String clientName) {this.clientName = clientName;}

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }

    public String getClientDOB() {
        return clientDOB;
    }

    public void setClientDOB(String clientDOB) {
        this.clientDOB = clientDOB;
    }

    public Character getClientGender() {
        return clientGender;
    }

    public void setClientGender(Character clientGender) {
        this.clientGender = clientGender;
    }
}
