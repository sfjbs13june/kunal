package com.kunal.app.repository;

import com.kunal.app.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface HopsitalRepository extends MongoRepository<Hospital, Integer> {
    public Hospital findById(int id);
    public void deleteById(int id);
    public Hospital save(Hospital hospital);
}
