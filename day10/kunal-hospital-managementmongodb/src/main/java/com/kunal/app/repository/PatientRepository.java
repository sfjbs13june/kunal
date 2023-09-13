package com.kunal.app.repository;

import com.kunal.app.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PatientRepository extends MongoRepository<Patient,Integer> {
    public Patient findById(int pid);
    public void deleteById(int pid);
    public Patient save(Patient patient);
}
