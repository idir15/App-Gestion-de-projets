package com.App_Gestion_de_Projet.app_gestion_de_projet.controller;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.TaskRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.Exception.RessourceNotFoundException;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;

import com.App_Gestion_de_Projet.app_gestion_de_projet.service.PersonService;
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
    private PersonService personService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("getTask/{id}")  // récupérer une tache par ID
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }


    @PostMapping("/AddTasks")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }
    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}