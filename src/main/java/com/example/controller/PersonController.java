package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.PersonEntity;
import com.example.exception.AgeNotAcceptableException;
import com.example.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;

	private Logger logger = LoggerFactory.getLogger(PersonController.class);

	
	@PostMapping(value = "/save", consumes = "application/json")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> savePerson(@RequestBody PersonEntity person) {
		String res="";
		try {
			if ((person.getAge()) <= 0) {
				throw new AgeNotAcceptableException("Wrong Age Input :" + person.getAge());
			} else {
				res = personService.savePerson(person);
			}
		}catch (Exception ex) {
			logger.error("Exception Occured :: " + ex.getMessage());
		}
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getperson", produces = "application/json")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<PersonEntity>> getAllPerson() {
		List<PersonEntity> personList = personService.getAllPerson();
		return new ResponseEntity<>(personList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getage/{name}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Integer> getAge(@PathVariable("name") String name){
	    Integer res = personService.getAge(name);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping(value="/home")
	public ResponseEntity<String> home(){
		String res = "Welcome to Home Page";
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping(value="/contact")
	public ResponseEntity<String> contact(){
		String res = "Thank you for contacting us";
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}
