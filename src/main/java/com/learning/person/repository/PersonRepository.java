package com.learning.person.repository;

import org.springframework.data.repository.CrudRepository;

import com.learning.person.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{

}
