package com.kunal.app.repository;

import com.kunal.app.model.Hospital;
import org.springframework.data.repository.CrudRepository;


public interface HopsitalRepository extends CrudRepository<Hospital, Integer> {
}
