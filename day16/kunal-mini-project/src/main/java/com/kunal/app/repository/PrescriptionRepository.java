package com.kunal.app.repository;

import com.kunal.app.model.Prescription;
import org.springframework.data.repository.CrudRepository;

public interface PrescriptionRepository extends CrudRepository <Prescription,Integer> {
}
