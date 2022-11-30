package com.nttdata.microservice.bankcustomers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.microservice.bankcustomers.collections.PersonCollection;
import com.nttdata.microservice.bankcustomers.services.IPersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private IPersonService personService;

	@GetMapping(value = "/list-all")
	public Flux<PersonCollection> getAllPersons() throws Exception{
		Flux<PersonCollection> list = personService.getAll();
		return list;
	}
	
	@PostMapping(value = "/store")
	public Mono<PersonCollection> savePerson(@RequestBody PersonCollection person) throws Exception{
		return personService.save(person);
	}
	
	@GetMapping("/find/{code}")
	public Mono<PersonCollection> getPersonByCode(@PathVariable("code") String code)
			throws Exception {
		return personService.getByCode(code);
	}
	
	@GetMapping("/findType/{code}")
	public Mono<String> getPersonTypeByCode(@PathVariable("code") String code)
			throws Exception {
		return personService.getByType(code);
	}
	

}
