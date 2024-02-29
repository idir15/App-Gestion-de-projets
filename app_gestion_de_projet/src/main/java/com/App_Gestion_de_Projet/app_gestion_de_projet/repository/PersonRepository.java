package com.App_Gestion_de_Projet.app_gestion_de_projet.repository;

import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Person;
import com.App_Gestion_de_Projet.app_gestion_de_projet.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
