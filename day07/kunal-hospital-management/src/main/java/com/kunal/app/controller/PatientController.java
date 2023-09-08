package com.kunal.app.controller;

import com.kunal.app.model.Patient;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PatientController {
    Map<String, Patient> patientMap= new HashMap<String,Patient>();

    @PostMapping("save/patient")
    public Patient createPatient(@RequestBody Patient patient){
        patientMap.put(patient.getPatientname(),patient);
        return patient;
    }

    @GetMapping("get/patient")
    public Patient getpatient(@RequestParam("patientname") String patientname){
        return patientMap.get(patientname);
    }

    @PutMapping("update/patient")
    public Patient updatepatient(@RequestParam("patientname") String patientname,@RequestParam("hospitalname") String hospitalname){
        Patient patient= patientMap.get(patientname);
        patient.setHospitalname(hospitalname);
        patientMap.put(patientname,patient);
        return patient;
    }

    @DeleteMapping("delete/patient")
    public void deletepatient(@RequestParam("patientname") String patientname){
        patientMap.remove(patientname);
    }
}
