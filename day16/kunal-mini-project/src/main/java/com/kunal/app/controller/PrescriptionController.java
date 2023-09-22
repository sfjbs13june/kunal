package com.kunal.app.controller;

import com.kunal.app.model.Prescription;
import com.kunal.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @PostMapping("/saveprescription")
    public Prescription saveprescription(@RequestBody final Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

    @GetMapping("/viewprescription")
    public List<Prescription> getprescription (@RequestParam final String patientName){
        return prescriptionRepository.findBypatientName(patientName);
    }
}
