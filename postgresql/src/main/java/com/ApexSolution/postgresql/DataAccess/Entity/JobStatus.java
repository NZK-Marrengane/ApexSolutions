package com.ApexSolution.postgresql.DataAccess.Entity;


public enum JobStatus{
    IN_PROGRESS("In Progress"),
    PENDING("Pending"),
    COMPLETE("Complete");

    private final String value;

    JobStatus(String value){
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
}
