package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Task {
    @Id
    private UUID id;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    @Column(name = "state")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;

    public Task(String nom, String description, LocalDate dateDebut, LocalDate dateFin, String etat, Person person) {
        this.id = UUID.randomUUID(); // Génération automatique d'un UUID lors de la création d'une nouvelle tâche
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.state = state;
        this.person = person;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setDateDebut(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(String state) {
        this.state = Boolean.valueOf(state);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nom='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + start_date +
                ", dateFin=" + end_date +
                ", etat='" + state + '\'' +
                ", personne=" + person +
                '}';
    }
}
