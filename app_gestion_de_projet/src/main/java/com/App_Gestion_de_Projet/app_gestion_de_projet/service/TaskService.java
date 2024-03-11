package com.App_Gestion_de_Projet.app_gestion_de_projet.service;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.PersonRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.ProjectRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.repository.TaskRepository;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    private PersonService personService;
    private PersonRepository personRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository, PersonRepository personRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

//    public Task saveTask(Task task) {
//        return taskRepository.save(task);
//
//    }
public Task saveTask(Task task) {
    Long personId = task.getPerson().getId();
    Long projectId = task.getProject().getId();

    Person existingPerson = personRepository.findById(personId)
            .orElseThrow(() -> new RuntimeException("Person with ID " + personId + " not found"));

    Project existingProject = projectRepository.findById(projectId)
            .orElseThrow(() -> new RuntimeException("Project with ID " + projectId + " not found"));

    task.setPerson(existingPerson);
    task.setProject(existingProject);

    return taskRepository.save(task);
}

    public ResponseEntity<Map<String, String>> deleteTask(Long id) {
        taskRepository.deleteById(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Task deleted successfully");
        return ResponseEntity.ok(response);
    }

}
