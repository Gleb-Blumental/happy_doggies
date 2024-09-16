package com.example.happy_doggies.DTO;

import com.example.happy_doggies.models.Person;
import lombok.Data;

@Data
public class PersonDTO {

    private String id;

    private String name;

    private String email;

    private String nationality;

    public PersonDTO(Person person){
        this.id = person.getPersonId();
        this.name = person.getName();
        this.email = person.getEmail();
        this.nationality = person.getNationality();
    }

    public Person toPerson(){
        return new Person();

    }
}