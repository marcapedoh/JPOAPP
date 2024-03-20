package com.example.api.controller;

import com.example.api.controller.API.OffreOpportuniteAPI;
import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.OffreOpportuniteDAO;
import com.example.api.services.OffreOpportuniteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OffreOpportuniteController implements OffreOpportuniteAPI {
    private OffreOpportuniteServices offreOpportuniteServices;

    @Autowired
    public OffreOpportuniteController(OffreOpportuniteServices offreOpportuniteServices) {
        this.offreOpportuniteServices = offreOpportuniteServices;
    }

    @Override
    public OffreOpportuniteDAO save(OffreOpportuniteDAO offreOpportuniteDAO) {
        return offreOpportuniteServices.save(offreOpportuniteDAO);
    }

    @Override
    public List<OffreOpportuniteDAO> findByEntreprise(EntrepriseDAO entrepriseDAO) {
        return offreOpportuniteServices.findByEntreprise(entrepriseDAO);
    }

    @Override
    public List<OffreOpportuniteDAO> findByDateDebut(LocalDate date) {
        return offreOpportuniteServices.findByDateDebut(date);
    }
}
