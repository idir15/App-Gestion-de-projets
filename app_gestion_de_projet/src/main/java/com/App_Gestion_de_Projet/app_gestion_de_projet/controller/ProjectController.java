
package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;

import com.App_Gestion_de_Projet.app_gestion_de_projet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/getAllproject")
    public List<Project> getAllprojects() {
        return projectService.getAllProject();
    }

    @PostMapping("/postAddproject")
    public Project addProjects(@RequestBody Project project) {
        return projectService.addProject(project);

    }

    @DeleteMapping("/deleteProject/{id}")
    public ResponseEntity<String> deletePersons(@PathVariable Long id) {
        return projectService.deletePerson(id);

    }

    @GetMapping("/getProject/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }
}







