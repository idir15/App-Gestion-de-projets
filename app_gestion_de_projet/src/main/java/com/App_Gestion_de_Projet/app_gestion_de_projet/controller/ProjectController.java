package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;

import com.App_Gestion_de_Projet.app_gestion_de_projet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projets")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

//    @GetMapping("/init")
//    public void addProjects() {
//
//        Project projet1 = new Project(UUID.randomUUID(),"Project 1", "Description 1", LocalDate.now(), LocalDate.now().plusMonths(3), false);
//        Project projet2 = new Project(UUID.randomUUID(), "Project 2", "Description 2", LocalDate.now().plusMonths(1), LocalDate.now().plusMonths(4), false);
//        Project projet3 = new Project(UUID.randomUUID(), "Project 3", "Description 3", LocalDate.now().plusMonths(2), LocalDate.now().plusMonths(5), false);
//        Project projet4 = new Project(UUID.randomUUID(), "Project 4", "Description 4", LocalDate.now().plusMonths(3), LocalDate.now().plusMonths(6), false);
//        Project projet5 = new Project(UUID.randomUUID(), "Project 5", "Description 5", LocalDate.now().plusMonths(4), LocalDate.now().plusMonths(7), false);
//        Project projet6 = new Project(UUID.randomUUID(), "Project 6", "Description 6", LocalDate.now().plusMonths(5), LocalDate.now().plusMonths(8), false);
//
//        projectService.addProject(projet1);
//        projectService.addProject(projet2);
//        projectService.addProject(projet3);
//        projectService.addProject(projet4);
//        projectService.addProject(projet5);
//        projectService.addProject(projet6);
//    }

}
