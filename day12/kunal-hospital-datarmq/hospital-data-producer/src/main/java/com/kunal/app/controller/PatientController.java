package com.kunal.app.controller;



import com.kunal.app.model.Patient;

import com.kunal.app.service.RabbitMQPatientSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prabbitmq")
public class PatientController {
    @Autowired
    RabbitMQPatientSender rabbitMQPatientSender;

    @GetMapping(value = "/pdataproducer")
    public String ptproducer(@RequestParam("patientname") String patientname, @RequestParam("pid") String pid, @RequestParam("hospitalname") String hospitalname, @RequestParam("disease") String disease) {

        Patient patient=new Patient();
        patient.setPatientname(patientname);
        patient.setPid(pid);
        patient.setHospitalname(hospitalname);
        patient.setDisease(disease);
        rabbitMQPatientSender.psend(patient);

        return "patient data sent Successfully";
    }

    @PostMapping(value = "/patient")
    public String postPatient(@RequestBody Patient patient) {

        rabbitMQPatientSender.psend(patient);

        return "Patient data sent Successfully";
    }
}
