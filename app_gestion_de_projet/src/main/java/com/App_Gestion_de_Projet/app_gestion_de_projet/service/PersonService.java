package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/getAllperson")
    public List<Person> getAllperson() {
        return personRepository.findAll();
    }

    @PostMapping("/postAddperson")
    public Person addPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    public ResponseEntity<String> deletePerson(@PathVariable Long id) {

        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
        }

        personRepository.deleteById(id);

        return ResponseEntity.ok("Deleted successfully");
    }

    public Optional<Person> getPersonById(@PathVariable Long id){
        return personRepository.findById(id);
    }

    public ResponseEntity<String> updatePersonById(Long id, Person updatedPerson) {

        Optional<Person> existingPersonOptional = personRepository.findById(id);

        if (existingPersonOptional.isPresent()) {

            Person existingPerson = existingPersonOptional.get();
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setFirstname(updatedPerson.getFirstname());

            personRepository.save(existingPerson);

            return ResponseEntity.ok("Project updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Project not found");
        }
    }
}