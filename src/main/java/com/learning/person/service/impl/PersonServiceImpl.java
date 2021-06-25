package com.learning.person.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.learning.person.model.Person;
import com.learning.person.repository.PersonRepository;
import com.learning.person.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	@Autowired
	PersonRepository personRepository;

	public List<Person> fetchAllPersons() {
		List<Person> personList = new ArrayList<Person>();
		Iterator<Person> itr = personRepository.findAll().iterator();
		while (itr.hasNext()) {
			personList.add(itr.next());
		}
		return personList;
	}

	public Person savePerson(Person p) {
		// TODO Auto-generated method stub
		Person newPerson = personRepository.save(p);
		return newPerson;
	}

	public boolean updatePerson(Person p, Integer id) {
		boolean isUpdated = false;
		if (personRepository.existsById(id) == true) {
			Person currentPerson = personRepository.findById(id).get();
			if (currentPerson != null) {
				if (p.getAge() != 0) {
					currentPerson.setAge(p.getAge());
				}
				if (p.getFirstName() != null && !(p.getFirstName().isEmpty())) {
					currentPerson.setFirstName(p.getFirstName());
				}
				if (p.getLastName() != null && !(p.getLastName().isEmpty())) {
					currentPerson.setLastName(p.getLastName());
				}
				personRepository.save(currentPerson);
				isUpdated = true;
			}
		}
		return isUpdated;
	}

	public boolean deletePerson(Integer id) {
		personRepository.deleteById(id);
		if (personRepository.existsById(id) == true) {
			return false;
		} else {
			return true;
		}
	}

}
