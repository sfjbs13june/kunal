package com.kunal.app.model;


import org.springframework.data.annotation.Id;

public class Patient {


    String patientname;
    @Id
    int pid;
    String hospitalname;
    String disease;

    public Patient(){}

    public Patient(String patientname, int pid, String hospitalname, String disease) {
        this.patientname = patientname;
        this.pid = pid;
        this.hospitalname = hospitalname;
        this.disease = disease;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public int getId() {
        return pid;
    }

    public void setId(int pid) {
        this.pid = pid;
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        this.hospitalname = hospitalname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
