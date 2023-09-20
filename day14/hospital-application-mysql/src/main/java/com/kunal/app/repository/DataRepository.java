package com.kunal.app.repository;

import com.kunal.app.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DataRepository {

    private Map<String, Patient> patientMap= new HashMap<String,Patient>();

    public Patient getPatient(String name){
        return patientMap.get(name);
    }

    public void savePatient(String name,Patient patient){
         patientMap.put(name,patient);
    }

    public void removePatient(String name){
         patientMap.remove(name);
    }

}
