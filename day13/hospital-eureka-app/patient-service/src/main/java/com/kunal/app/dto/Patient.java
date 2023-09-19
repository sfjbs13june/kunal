package com.kunal.app.dto;

public class Patient {
    private String pid;
    private String patientname;
    private String disease;

    public Patient(String pid, String patientname, String disease) {
        super();
        this.pid = pid;
        this.patientname = patientname;
        this.disease = disease;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPatientname() {
        return patientname;
    }

    public void setPatientname(String patientname) {
        this.patientname = patientname;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
