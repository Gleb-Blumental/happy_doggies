package com.example.happy_doggies.controllers;

import com.example.happy_doggies.DTO.PersonDTO;
import com.example.happy_doggies.models.Person;
import com.example.happy_doggies.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;


    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO requestBody) {
        var created = personService.createPerson(requestBody);

        if (created) {
            return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create person", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAllPeople(){
        var person = personService.getAllPeople();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable String id){
        var person = personService.getPersonById(id);

        if(person.isPresent()){
            return new ResponseEntity<>(person.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable String id, @RequestBody Person person){
        var isUpdated = personService.updatePerson(id, person);

        if(isUpdated){
            return new ResponseEntity<>("Person updated", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Person not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable String id){
        var isDeleted = personService.deletePerson(id);

        if(isDeleted){
            return new ResponseEntity<>("Person by this ID is deleted", HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity("Could not find the person by this ID", HttpStatus.NOT_FOUND);
        }
    }
}
