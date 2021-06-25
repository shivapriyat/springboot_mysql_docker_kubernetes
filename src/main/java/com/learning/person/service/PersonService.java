package com.learning.person.service;

import java.util.List;

import com.learning.person.model.Person;

public interface PersonService {

	List<Person> fetchAllPersons();

	Person savePerson(Person p);

	boolean updatePerson(Person p, Integer id);

	boolean deletePerson(Integer id);

	
}
