package com.plateit.project.models;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeverageRepository extends MongoRepository<Beverage, String>{

}
