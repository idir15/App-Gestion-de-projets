package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name ="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "end_date")
    private LocalDate end_date;

    @Column(name ="state")
    private Boolean state;

    public Project() {
    }
    public Project(long id, String name, String description, LocalDate start_date, LocalDate end_date, Boolean state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.state = state;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean State) {
        this.state = State;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return start_date;
    }

    public void setStartDate(LocalDate startDate) {
        this.start_date = startDate;
    }

    public LocalDate getDateFin() {
        return end_date;
    }

    public void setEndDate(LocalDate endDate) {
        this.end_date = endDate;
    }



    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", state=" + state +

                '}';
    }
}
