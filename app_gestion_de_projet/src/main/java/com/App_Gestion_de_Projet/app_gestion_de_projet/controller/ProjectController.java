
package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        return projectService.deleteProject(id);

    }

    @GetMapping("/getProject/{id}")
    public Optional<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<String> updateProjectById(@PathVariable Long id, @RequestBody Project updatedProject) {
        return projectService.updateProjectById(id, updatedProject);
    }
}







