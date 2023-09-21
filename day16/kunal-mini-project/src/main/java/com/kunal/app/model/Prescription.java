package com.kunal.app.model;

import javax.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue
    @Column(name = "prescriptionId")
    private int prescriptionId;

    @Column(name = "appointmentId")
    private String appointmentId;

    @Column(name = "description")
    private String description;

    @Column(name = "patientName")
    private String patientName;

    @Column(name = "doctorName")
    private String doctorName;


    public Prescription() {

    }

    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
