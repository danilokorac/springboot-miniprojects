package com.springboot.backend.model;

import lombok.Data;

import javax.persistence.*;

@Data   // Used for constuctors
@Entity // Annotation specifies that the calss is an entity
@Table(name = "employees")
public class Employee {
    @Id //Primary key of entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifies the generation strategies for the values of primary keys, automatically increase by 1
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;


}
