package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.TaskRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;
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

}
