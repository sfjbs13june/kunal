package com.kunal.app.model;


import org.springframework.data.annotation.Id;

public class Appointment {

    @Id
    private String appointmentID;
    private String patientName;
    private String doctorName;
    private String date;
    private Prescription prescription;

    public Appointment() {}
    public Appointment(String appointmentID, String patientName, String doctorName, String date, Prescription prescription) {
        this.appointmentID = appointmentID;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.prescription = prescription;
    }


    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }


    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
