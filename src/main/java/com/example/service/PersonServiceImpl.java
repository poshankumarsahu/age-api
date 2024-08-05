package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.PersonEntity;
import com.example.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepo;

	@Override
	public String savePerson(PersonEntity person) {
		PersonEntity res = personRepo.save(person);
		return "Added with id : "+res.getId();
	}
	
	@Override
	public List<PersonEntity> getAllPerson(){
		return personRepo.findAll();
	}

	@Override
	public Integer getAge(String name) {
		return personRepo.getAge(name);
	}

}
