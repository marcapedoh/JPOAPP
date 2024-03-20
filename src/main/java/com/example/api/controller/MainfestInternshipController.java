package com.example.api.controller;

import com.example.api.controller.API.ManifestInternshipAPI;
import com.example.api.dao.ManifestIntershipDAO;
import com.example.api.models.Observation;
import com.example.api.services.ManifestIntershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MainfestInternshipController implements ManifestInternshipAPI {
    private ManifestIntershipService manifestIntershipService;

    @Autowired
    public MainfestInternshipController(ManifestIntershipService manifestIntershipService) {
        this.manifestIntershipService = manifestIntershipService;
    }
    @Override
    public ManifestIntershipDAO save(ManifestIntershipDAO manifestIntershipDAO) {
        return manifestIntershipService.save(manifestIntershipDAO);
    }

    @Override
    public List<ManifestIntershipDAO> findAllManisfestionInteret() {
        return manifestIntershipService.findAllManisfestionInteret();
    }

    @Override
    public Observation validationMnifestation(ManifestIntershipDAO manifestIntershipDAO, boolean acception, String remarque) {
        return manifestIntershipService.validationMnifestation(manifestIntershipDAO,acception,remarque);
    }
}
