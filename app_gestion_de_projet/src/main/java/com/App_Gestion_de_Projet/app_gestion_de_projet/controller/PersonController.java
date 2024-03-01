package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.Exception.RessourceNotFoundException;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    private PersonRepository profilrepo;

    public void setProfilrepo(PersonRepository profilrepo) {
        this.profilrepo = profilrepo;
    }

    @GetMapping("/getAllperson")
    public List<Person> getAllexperiences() {
        return profilrepo.findAll();
    }

    @PostMapping("/putAddperson")
    public Person addcharge(@RequestBody Person profil) {



        return profilrepo.save(profil);
    }


   /* @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<Map<String, Boolean>> deletecharge(@PathVariable Long id) {
        Person profil = profilrepo.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Profil n'éxiste pas selon le cod :" + id));
        profilrepo.delete(profil);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);

    }*/

    /*@PostMapping("/postUpdateperson")
    public ResponseEntity<Person> updatecharge(@RequestBody Person profil) {
        Person pr = profilrepo.findById(profil.getId()).orElseThrow(
                () -> new RessourceNotFoundException("Profil  n'éxiste pas selon le code :" + profil.getId()));

        Person updatedprofil = profilrepo.save(pr);

        return ResponseEntity.ok(updatedprofil);

    }*/

    /*@GetMapping("/getPersonbyId/{id}")
    public ResponseEntity<Person> getchargebyId(@PathVariable Long id) {
        Person profil = profilrepo.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Profil n'éxiste pas selon le code  :" + id));
        return ResponseEntity.ok(profil);

    }*/

}