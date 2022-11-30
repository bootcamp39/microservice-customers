package com.nttdata.microservice.bankcustomers.services;

import com.nttdata.microservice.bankcustomers.collections.PersonCollection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {
	public Flux<PersonCollection> getAll() throws Exception;
	public Mono<PersonCollection> getByCode(String code) throws Exception;
	public Mono<String> getByType(String code) throws Exception;
	public Mono<PersonCollection> save(PersonCollection collection) throws Exception;
	public Mono<PersonCollection> update(PersonCollection updatedCollection, String code) throws Exception;
	public Mono<Void> delete(String code) throws Exception;
}
