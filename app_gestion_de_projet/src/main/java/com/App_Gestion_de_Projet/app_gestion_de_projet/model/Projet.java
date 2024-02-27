package com.App_Gestion_de_Projet.app_gestion_de_projet.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Projet {
    @Id
    private UUID id;

    @Column(name ="name")
    private String name;

    private String description;

    @Column(name = "date_Debut")
    private LocalDate dateDebut;

    @Column(name = "date_Fin")
    private LocalDate dateFin;

    @ManyToOne
    @JoinColumn(name = "id_personne")
    private Personne personne;

    public Projet(String name, LocalDate dateDebut, LocalDate dateFin, Personne personne) {
        this.id = UUID.randomUUID(); // Génération automatique d'un UUID lors de la création d'un nouveau projet
        this.name = name;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.personne = personne;
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

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", personne=" + personne +
                '}';
    }
}
