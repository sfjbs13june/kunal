package com.kunal.app.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {
    String patientname;
    int id;
    String hospitalname;
    String disease;

    public Patient(){}

    public Patient(String patientname, int id, String hospitalname, String disease) {
        this.patientname = patientname;
        this.id = id;
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
