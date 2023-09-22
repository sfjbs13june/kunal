package com.kunal.app.controller;

import com.kunal.app.model.Appointment;
import com.kunal.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody final Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/doctorappointment") public List<Appointment> getAppointment(@RequestParam String doctorName){
       return appointmentRepository.findBydoctorName(doctorName);
    }

}
