package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Projet {
    @Id
    private Integer id;
    @Column(name ="name")
    private String name;

    private String description;
    @Column(name = "date_Debut")
    private LocalDate dateDebut;
    @Column(name = "date_Fin")
    private LocalDate dateFin;

    public Projet(Integer id, String name, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                '}';
    }
}
