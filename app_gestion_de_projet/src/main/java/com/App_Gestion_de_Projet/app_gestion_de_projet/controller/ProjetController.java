package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Projet;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;
    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @GetMapping("/init")
    public void ajoutProjet() {

        Projet projet1 = new Projet(1, "Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusMonths(3));
        Projet projet2 = new Projet(2, "Project 2", "Description 2", LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(4));
        Projet projet3 = new Projet(3, "Project 3", "Description 3", LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5));
        Projet projet4 = new Projet(4, "Project 4", "Description 4", LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6));
        Projet projet5 = new Projet(5, "Project 5", "Description 5", LocalDate.now().plusMonths(4), LocalDate.now().plusMonths(7));
        Projet projet6 = new Projet(6, "Project 6", "Description 6", LocalDate.now().plusMonths(5), LocalDate.now().plusMonths(8));

        projetService.addProject(projet1);
        projetService.addProject(projet2);
        projetService.addProject(projet3);
        projetService.addProject(projet4);
        projetService.addProject(projet5);
        projetService.addProject(projet6);
    }

}
