package com.example.api.services;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.OffreOpportuniteDAO;

import java.time.LocalDate;
import java.util.List;

public interface OffreOpportuniteServices {
    OffreOpportuniteDAO save(OffreOpportuniteDAO offreOpportuniteDAO);
    List<OffreOpportuniteDAO> findByEntreprise(EntrepriseDAO entrepriseDAO);
    List<OffreOpportuniteDAO> findByDateDebut(LocalDate date);
}
