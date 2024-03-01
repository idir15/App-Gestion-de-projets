package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    @Transactional
    public void addPerson(Person person) {
        try {
            personRepository.save(person);
            System.out.println("Personne ajoutée avec succès : " + person.toString());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la personne : " + e.getMessage());
            e.printStackTrace();  // Affichez la trace complète de l'exception
        }
    }
}