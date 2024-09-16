package com.example.happy_doggies.repositories;

import com.example.happy_doggies.models.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, String>{

}
