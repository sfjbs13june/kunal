package com.kunal.app.repository;

import com.kunal.app.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment,Integer> {
}
