package com.kunal.app.repository;

import com.kunal.app.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment,String> {
    public List<Appointment> findBydoctorName(String doctorName);
    public List<Appointment> findBypatientName(String patientName);
    public Appointment save(Appointment appointment);
}
