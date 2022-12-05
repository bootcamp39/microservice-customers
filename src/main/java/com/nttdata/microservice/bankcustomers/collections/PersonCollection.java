package com.nttdata.microservice.bankcustomers.collections;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "persons")
public class PersonCollection {

	@Id
	private ObjectId id;
	
	private String code;
	private String phone;
	private String email;
	private String address;
	private String state;
	private String personType;
	
	//LEGAL
	private String ruc;
	private String companyName;
	
	//PERSON
	private String firstName;
	private String lastName;
	private String typeDocument;
	private String numberDocument;
	private Date birthday;
	
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;
	
	
	
	
}
