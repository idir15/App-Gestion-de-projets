package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.TaskRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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


    public ResponseEntity<Map<String, String>> deleteTask(Long id) {
        taskRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Task deleted successfully");
        return ResponseEntity.ok(response);
    }

}
