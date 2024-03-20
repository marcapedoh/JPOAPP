package com.example.api.controller;

import com.example.api.controller.API.EntrepriseAPI;
import com.example.api.dao.EntrepriseDAO;
import com.example.api.services.EntrepriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class EntrepriseController implements EntrepriseAPI {
    private EntrepriseServices entrepriseServices;

    @Autowired
    public EntrepriseController(EntrepriseServices entrepriseServices) {
        this.entrepriseServices = entrepriseServices;
    }

    @Override
    public EntrepriseDAO save(EntrepriseDAO entrepriseDAO) {
        return entrepriseServices.save(entrepriseDAO);
    }

    @Override
    public EntrepriseDAO findById(Integer id) {
        return entrepriseServices.findById(id);
    }

    @Override
    public List<EntrepriseDAO> findAll() {
        return entrepriseServices.findAll();
    }
}
