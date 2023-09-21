package com.kunal.app.controller;

import com.kunal.app.model.Prescription;
import com.kunal.app.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public @ResponseBody
    Iterable<Prescription> getAllPrescriptions(){
        return prescriptionRepository.findAll();
    }

    @PostMapping("/saveprescription")
    public @ResponseBody
    String savePrescription(@RequestBody final Prescription prescription){
        prescriptionRepository.save(prescription);
        return "prescription saved";
    }
}
