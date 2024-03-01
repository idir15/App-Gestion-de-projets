package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.Exception.RessourceNotFoundException;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;

import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.ProjectRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ProjectRepository projectrepo;

    public ProjectController(ProjectRepository projectrepo) {
        this.projectrepo = projectrepo;
    }

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/getAllproject")
    public List<Project> getAllprojects() {
        return projectService.getAllProject();
    }

    @PostMapping("/postAddproject")
    public Project addProjects(Project project) {
        return projectService.addProject(project);

    }
    @DeleteMapping("/deletePerson/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        // Ensure that 'projectrepo' is initialized before using it
        Project project = projectrepo.findById(id).orElse(null);

        // Add logic for deleting the project

        return ResponseEntity.ok("Deleted successfully");
    }

}







