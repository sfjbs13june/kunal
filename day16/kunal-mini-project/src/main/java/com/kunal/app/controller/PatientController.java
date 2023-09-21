package com.kunal.app.controller;

import com.kunal.app.model.Appointment;
import com.kunal.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/myappointment")
    public @ResponseBody Iterable<Appointment> getMyAppointments(@RequestParam("patientname") final String patientName){
        return appointmentRepository.findAll();
    }

    @PostMapping("/save")
    public @ResponseBody String saveAppointment(@RequestBody final Appointment appointment){
        appointmentRepository.save(appointment);
        return "Patient appointment saved";
    }

}
