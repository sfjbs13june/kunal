package com.kunal.app.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Patient {

    @Column(name = "patientname")
    String patientname;

    @Id
    @GeneratedValue
    @Column(name = "id")
    int id;

    @Column(name = "hospitalname")
    String hospitalname;

    @Column(name="disease")
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
