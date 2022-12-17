package com.nttdata.microservice.bankcustomers.services;

import java.util.Date;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.microservice.bankcustomers.collections.PersonCollection;
import com.nttdata.microservice.bankcustomers.collections.enums.PersonTypeEnum;
import com.nttdata.microservice.bankcustomers.repository.IPersonRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements IPersonService{
	
	@Autowired
	private IPersonRepository repository;

	@Override
	public Mono<PersonCollection> saveCustomerPersonal(PersonCollection collection) {
		collection.setCode(UUID.randomUUID().toString());
		collection.setPersonType(PersonTypeEnum.PERSONAL.toString());
		collection.setCreatedAt(new Date());
		return repository.save(collection);
	}

	@Override
	public Mono<PersonCollection> saveCustomerEnterprise(PersonCollection collection) {
		collection.setCode(UUID.randomUUID().toString());
		collection.setPersonType(PersonTypeEnum.ENTERPRISE.toString());
		collection.setCreatedAt(new Date());
		return repository.save(collection);
	}

	@Override
	public Flux<PersonCollection> list() {
		return repository.findAll();
	}

	@Override
	public Mono<Boolean> checkIfCustomerExist(String code) {
		return repository.findByCode(code).next().flatMap(collection -> {
			return Mono.just(collection!=null?true:false);
		} );
	}

	@Override
	public Mono<Boolean> checkIfCustomerPersonal(String code) {
		return repository.findByCode(code).next().flatMap(collection -> {
			return Mono.just(collection.getPersonType().equals(PersonTypeEnum.PERSONAL.toString())?true:false);
		} );
	}

	@Override
	public Mono<Boolean> checkIfCustomerEnterprise(String code) {
		return repository.findByCode(code).next().flatMap(collection -> {
			return Mono.just(collection.getPersonType().equals(PersonTypeEnum.ENTERPRISE.toString())?true:false);
		} );
	}

	/*@Override
	public Flux<PersonCollection> getAll() throws Exception {
		return personRepository.findAll();
	}*/

	/*@Override
	public Mono<PersonCollection> getByCode(String code) throws Exception {
		
		Mono<PersonCollection> col = personRepository.findAll().filter(x -> x.getCode().equals(code)).next();
		return col;
	}*/

	/*@Override
	public Mono<PersonCollection> save(PersonCollection collection) throws Exception {

		collection.setCode(UUID.randomUUID().toString());
		collection.setState("1");
		collection.setCreatedAt(new Date());
		
		return personRepository.save(collection);
		
	}*/

	/*@Override
	public Mono<PersonCollection> update(PersonCollection updatedCollection, String code) throws Exception {
		
		Mono<PersonCollection> result = this.getByCode(code);
		PersonCollection resultNew = result.block();
		resultNew.setEmail(updatedCollection.getEmail());
		resultNew.setUpdatedAt(new Date());
		return personRepository.save(resultNew);
	}*/

	/*@Override
	public Mono<Void> delete(String code) throws Exception {
		
		Mono<PersonCollection> result = this.getByCode(code);
		PersonCollection resultNew = result.block();
		
		return personRepository.delete(resultNew);
	}*/

	/*@Override
	public Mono<String> getByType(String code) throws Exception {
		Mono<String> col = personRepository.findAll().filter(x -> x.getCode().equals(code)).next().map(PersonCollection::getPersonType);
		return col;
	}*/

}
