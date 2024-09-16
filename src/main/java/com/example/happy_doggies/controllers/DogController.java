package com.example.happy_doggies.controllers;

import com.example.happy_doggies.models.Dog;
import com.example.happy_doggies.services.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/dogs")
@RequiredArgsConstructor
public class DogController {

    private final DogService service;


    @PostMapping
    public ResponseEntity<String> createDog(@RequestBody Dog dog){
        var created = service.createDog(dog);

        if(created){
            return new ResponseEntity<>("Dog created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Failed to create dog", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Dog>> getAllDogs(){
        var dogs = service.getAllDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable String id){
        var dog = service.getDogById(id);

        if(dog.isPresent()){
            return new ResponseEntity<>(dog.get(),HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDog(@PathVariable String id, @RequestBody Dog dog){
        var isUpdated = service.updateDog(id, dog);

        if(isUpdated){
            return new ResponseEntity<>("Dog updated", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Dog not updated", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDog(@PathVariable String id){
        var isDeleted = service.deleteDog(id);

        if(isDeleted){
            return new ResponseEntity<>("Dog ID is deleted", HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity("Could not find the dog by ID", HttpStatus.NOT_FOUND);
        }
    }
}
