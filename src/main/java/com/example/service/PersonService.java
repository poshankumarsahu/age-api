package com.example.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.PersonEntity;

@Service
public interface PersonService {
	
	public String savePerson(PersonEntity person);
	
	public List<PersonEntity> getAllPerson();
	
	public Integer getAge(String name);


}
