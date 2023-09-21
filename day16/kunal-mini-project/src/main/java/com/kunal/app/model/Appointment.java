package com.kunal.app.model;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    @Column(name = "appointmentId")
    private int appointmentID;

    @Column(name = "patientName")
    private String patientName;

    @Column(name = "doctorname")
    private String doctorname;

    @Column(name = "date")
    private String date;



    public Appointment() {

    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
