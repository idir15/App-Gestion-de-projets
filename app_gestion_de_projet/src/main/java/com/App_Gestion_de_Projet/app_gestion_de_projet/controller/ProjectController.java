package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;

import com.App_Gestion_de_Projet.app_gestion_de_projet.Exception.ResourceNotFoundException;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;
import com.App_Gestion_de_Projet.app_gestion_de_projet.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/addTask")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/getAllProjects")
    public List<Project> getAllProjects() {
        // Ajoutez le service correspondant pour récupérer la liste des projets
        // Exemple fictif : return projectService.getAllProjects();
        return null;
    }

    @GetMapping("/getProject/{id}")
    public Project getProjectById(@PathVariable Long id) {
        // Ajoutez le service correspondant pour récupérer un projet par ID
        // Exemple fictif : return projectService.getProjectById(id);
        return null;
    }

    @PostMapping("/addProject")
    public Project saveProject(@RequestBody Project project) {
        // Ajoutez le service correspondant pour enregistrer un projet
        // Exemple fictif : return projectService.saveProject(project);
        return null;
    }
}
