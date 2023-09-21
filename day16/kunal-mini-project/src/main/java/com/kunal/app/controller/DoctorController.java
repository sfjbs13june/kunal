package com.kunal.app.controller;

import com.kunal.app.model.Appointment;
import com.kunal.app.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping("/doctorappointment")
    public @ResponseBody Iterable<Appointment> getAppointments(@RequestParam String doctorName){
        return appointmentRepository.findAll();
    }

    @PostMapping("/save")
    public @ResponseBody String saveAppointment(@RequestBody final Appointment appointment){
        appointmentRepository.save(appointment);
        return "Doctor appointment saved";
    }

}
