package com.App_Gestion_de_Projet.app_gestion_de_projet.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException  extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RessourceNotFoundException (String message) {
        super(message);
    }
}

