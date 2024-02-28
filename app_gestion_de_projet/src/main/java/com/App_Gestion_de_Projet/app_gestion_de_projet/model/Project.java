package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Project {
    @Id
    //private UUID id;
    private UUID id;

    @Column(name ="name")
    private String name;

    private String description;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;


    private Boolean state;




    public Boolean getState() {
        return state;
    }

    public void setState(String state) {
        this.state = Boolean.valueOf(state);
    }

    public Project(UUID uuid, String s, String string, LocalDate now, LocalDate localDate, boolean b) {
    }
    public Project(String name, String description, LocalDate start_date, LocalDate end_date, boolean state, Person person) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.state = state;

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

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate startDate) {
        this.start_date = start_date;
    }

    public LocalDate getDateFin() {
        return end_date;
    }

    public void setEndDate(LocalDate endDate) {
        this.end_date = end_date;
    }



    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", state='" + state + '\'' +

                '}';
    }
}
