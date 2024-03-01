package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Ajoutez les méthodes pour gérer les projets

    // Exemple :
    public List<Project> getAllProjects() {
        // Ajoutez la logique pour récupérer tous les projets
        // Exemple fictif : return projectRepository.findAll();
        return null;
    }

    public Project getProjectById(Long id) {
        // Ajoutez la logique pour récupérer un projet par ID
        // Exemple fictif : return projectRepository.findById(id).orElse(null);
        return null;
    }

    public Project saveProject(Project project) {
        // Ajoutez la logique pour enregistrer un projet
        // Exemple fictif : return projectRepository.save(project);
        return null;
    }
}
