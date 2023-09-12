package com.kunal.app.controller;

import com.kunal.app.model.Patient;

import com.kunal.app.repository.HopsitalRepository;
import com.kunal.app.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/patient")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @PostMapping("/save")
    public @ResponseBody
    String createPatient(@RequestBody final Patient patient){
       patientRepository.save(patient);
       return "saved";
    }

    @GetMapping("/get")
    public @ResponseBody
    Iterable<Patient> getAll(){
        return patientRepository.findAll();
    }

    @DeleteMapping("/delete")
    public @ResponseBody
    String store(@RequestParam("id") final int id) {
        patientRepository.deleteById(id);
        return "deleted";
    }
}
