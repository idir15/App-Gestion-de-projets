package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import org.hibernate.annotations.IdGeneratorType;

import java.time.LocalDate;
import java.util.Date;

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

    @Column(name = "start_date")
    private String startdate;

    @Column(name = "end_date")
    private String enddate;

    @Column(name ="state")
    private Boolean state;

    public Project() {
    }
    public Project(long id, String name, String description, String start_date, String end_date, Boolean state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startdate = start_date;
        this.enddate = end_date;
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

    public String getStartDate() {
        return startdate;
    }

    public void setStartDate(String start_date) {
        this.startdate = start_date;
    }

    public String getEndDate() {
        return enddate;
    }

    public void setEndDate(String end_date) {
        this.enddate = end_date;
    }



    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", start_date=" + startdate +
                ", end_date=" + enddate +
                ", state=" + state +

                '}';
    }
}
