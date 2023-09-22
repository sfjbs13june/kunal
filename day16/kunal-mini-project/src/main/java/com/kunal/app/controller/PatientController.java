package com.kunal.app.controller;

import com.kunal.app.model.Appointment;
import com.kunal.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody final Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/myappointments")
    public List<Appointment> getMyappointments(@RequestParam String patientName){
        return appointmentRepository.findBypatientName(patientName);
    }

}
