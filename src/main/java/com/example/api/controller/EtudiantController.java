package com.example.api.controller;

import com.example.api.controller.API.EtudiantAPI;
import com.example.api.dao.EtudiantDAO;
import com.example.api.services.EtudiantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EtudiantController implements EtudiantAPI {
    private EtudiantServices etudiantServices;

    @Autowired
    public EtudiantController(EtudiantServices etudiantServices) {
        this.etudiantServices = etudiantServices;
    }

    @Override
    public EtudiantDAO save(EtudiantDAO etudiantDAO) {
        return etudiantServices.save(etudiantDAO);
    }

    @Override
    public EtudiantDAO findById(Integer id) {
        return etudiantServices.findById(id);
    }

    @Override
    public List<EtudiantDAO> findAll() {
        return etudiantServices.findAll();
    }
}
