package com.example.happy_doggies.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String PersonId;

    private String name;

    private String nationality;

    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Dog> dogs;
}