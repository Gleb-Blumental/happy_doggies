package com.example.happy_doggies.repositories;

import com.example.happy_doggies.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
