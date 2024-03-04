package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonService personService;


    @Autowired
    public PersonController(PersonService pesrsonService) {
        this.personService = pesrsonService;
    }

    @GetMapping("/getAllperson")
    public List<Person> getAllperson() {
        return personService.getAllperson();
    }

    @PostMapping("/postAddperson")
    public Person addPersons(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletePersons(@PathVariable Long id) {
        return personService.deletePerson(id);

    }
    @GetMapping("/getPerson/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @PutMapping("/updatePerson/{id}")
    public ResponseEntity<String> updatePersonById(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personService.updatePersonById(id, updatedPerson);
    }


}