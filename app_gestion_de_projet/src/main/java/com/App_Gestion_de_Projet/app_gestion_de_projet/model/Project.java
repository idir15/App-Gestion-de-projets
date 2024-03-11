package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="name")
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "description")
    private String description;

    @Column(name = "startDate ")
    private LocalDate startDate;

    @Column(name = "endDate")
    private LocalDate endDate;

    @Column(name ="state")
    private Boolean state;

    public Project() {
    }
    public Project(long id, String name, String description, LocalDate startDate, LocalDate endDate, Boolean state) {


        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate
;

        this.endDate = endDate;
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
        return startDate;
    }

    public void setStartDate(LocalDate startDate
) {
        this.startDate = startDate;

    }



    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }



    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate =" + startDate +
                ", endDate=" + endDate +
                ", state=" + state +

                '}';
    }
}
