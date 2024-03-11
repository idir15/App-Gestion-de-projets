package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Person {
    @Id
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="firstname")
    private String firstname;
    public Person(){}

    public Person(Long id, String name, String firstname) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                '}';
    }
}
