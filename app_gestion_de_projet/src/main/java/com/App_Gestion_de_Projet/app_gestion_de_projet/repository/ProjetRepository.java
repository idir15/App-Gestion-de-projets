package com.App_Gestion_de_Projet.app_gestion_de_projet.repository;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {
}
