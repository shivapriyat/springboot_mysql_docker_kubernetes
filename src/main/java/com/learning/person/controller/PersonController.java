package com.learning.person.controller;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.person.model.Person;
import com.learning.person.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/person")
	public ResponseEntity getAllPersons() {
		List<Person> allPersons = personService.fetchAllPersons();
		return new ResponseEntity(allPersons, HttpStatus.OK);
	}
	
	@PostMapping("/person")
	public ResponseEntity savePerrson(@RequestBody Person p) {
		Person newPerson = personService.savePerson(p);
		return new ResponseEntity(newPerson, HttpStatus.OK);
	}
	@PutMapping("/person/{id}")
	public ResponseEntity updatePerson(@RequestBody Person p, @PathVariable("id") Integer id) {
		boolean isUpdated = personService.updatePerson(p,id);
		if(isUpdated) {
			return new ResponseEntity("{\"msg\": \"updated successfully\"}", HttpStatus.OK);	
		}
		else {
			return new ResponseEntity("{\"msg\": \"updated failed\"}", HttpStatus.OK);
		}
		
	}
	@DeleteMapping("/person/{id}")
	public ResponseEntity deletePerson(@PathVariable("id") Integer id) {
		boolean isDeleted = personService.deletePerson(id);
		if(isDeleted) {
			return new ResponseEntity("{\"msg\": \"deleted successfully\"}", HttpStatus.OK);	
		}
		else {
			return new ResponseEntity("{\"msg\": \"delete failed\"}", HttpStatus.OK);
		}
	}
}
