package com.kunal.app.repository;

import com.kunal.app.model.Appointment;
import com.kunal.app.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PrescriptionRepository extends MongoRepository<Prescription,String> {
    public Prescription save(Prescription prescription);
    public List<Prescription> findBypatientName(String patientName);
}
