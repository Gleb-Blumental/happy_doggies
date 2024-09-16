package com.example.happy_doggies.services;

import com.example.happy_doggies.DTO.PersonDTO;
import com.example.happy_doggies.models.Person;
import com.example.happy_doggies.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository PersonRepository;

    public boolean createPerson(PersonDTO dto) {
        try {
            PersonRepository.save(dto.toPerson());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<Person> getAllPeople() {
        return PersonRepository.findAll();
    }


    public Optional<Person> getPersonById(String id) {
        return PersonRepository.findById(id);
    }


    public boolean updatePerson(String id, Person updatedPerson){
        Optional<Person> existingPerson = PersonRepository.findById(id);

        if (existingPerson.isPresent()) {
            Person person = existingPerson.get();

            person.setName(updatedPerson.getName());
            person.setEmail(updatedPerson.getEmail());
            person.setNationality(updatedPerson.getNationality());

            PersonRepository.save(person);

            return true;
        }
        else{
            return false;
        }
    }


    public boolean deletePerson(String id){
        Optional<Person> existingPerson = PersonRepository.findById(id);

        if(existingPerson.isPresent()){
            PersonRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
