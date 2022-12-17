package com.nttdata.microservice.bankcustomers.services;

import com.nttdata.microservice.bankcustomers.collections.PersonCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {
	
	public Mono<PersonCollection> saveCustomerPersonal(PersonCollection collection);
	public Mono<PersonCollection> saveCustomerEnterprise(PersonCollection collection);
	
	public Flux<PersonCollection> list();
	
	public Mono<Boolean> checkIfCustomerExist(String code);
	public Mono<Boolean> checkIfCustomerPersonal(String code);
	public Mono<Boolean> checkIfCustomerEnterprise(String code);
	
}
