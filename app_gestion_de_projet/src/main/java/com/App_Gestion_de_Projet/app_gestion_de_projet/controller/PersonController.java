package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }


    @GetMapping("/addperson")
    public void addPersons() {
        Person person1 = new Person(1, "Name1", "FirstName1");
        Person person2 = new Person(2, "Name2", "FirstName2");
        Person person3 = new Person(3, "Name3", "FirstName3");
        Person person4 = new Person(4, "Name4", "FirstName4");
        Person person5 = new Person(5, "Name5", "FirstName5");
        Person person6 = new Person(6, "Name6", "FirstName6");
        Person person7 = new Person(7, "Name7", "FirstName7");
        Person person8 = new Person(8, "Name8", "FirstName8");

        personService.addPerson(person1);
        personService.addPerson(person2);
        personService.addPerson(person3);
        personService.addPerson(person4);
        personService.addPerson(person5);
        personService.addPerson(person6);
        personService.addPerson(person7);
        personService.addPerson(person8);
    }
}
