package com.kunal.app.controller;

import com.kunal.app.model.Patient;

import com.kunal.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    String createPatient(@RequestBody final Patient patient){
       patientRepository.save(patient);
       return "saved";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void modifyByID(@RequestParam int pid, @RequestParam String hospitalname) {
        Patient patient = patientRepository.findById(pid);
        patient.setHospitalname(hospitalname);
        patientRepository.save(patient);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    String store(@RequestParam int pid)  {
        patientRepository.deleteById(pid);
        return "deleted";
    }
}
