package com.example.api.services;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.ManifestIntershipDAO;
import com.example.api.models.Observation;

import java.util.List;

public interface ManifestIntershipService {
    ManifestIntershipDAO save(ManifestIntershipDAO manifestIntershipDAO);
    List<ManifestIntershipDAO> findAllManisfestionInteret();
    Observation validationMnifestation(ManifestIntershipDAO manifestIntershipDAO,boolean acception,String remarque);
}
