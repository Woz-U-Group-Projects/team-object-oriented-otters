package com.example.groupproject.models;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String>{

}
