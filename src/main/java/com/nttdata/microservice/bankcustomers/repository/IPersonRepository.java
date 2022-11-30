package com.nttdata.microservice.bankcustomers.repository;

import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.microservice.bankcustomers.collections.PersonCollection;

@Repository
public interface IPersonRepository extends ReactiveCrudRepository<PersonCollection, ObjectId>{

}
