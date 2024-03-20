package com.example.api.controller;

import com.example.api.controller.API.DomainEtudeAPI;
import com.example.api.dao.DomainEtudeDAO;
import com.example.api.services.DomainEtudeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DomainEtudeController implements DomainEtudeAPI {
    private DomainEtudeServices domainEtudeServices;

    @Autowired
    public DomainEtudeController(DomainEtudeServices domainEtudeServices) {
        this.domainEtudeServices = domainEtudeServices;
    }

    @Override
    public DomainEtudeDAO save(DomainEtudeDAO domainEtudeDAO) {
        return domainEtudeServices.save(domainEtudeDAO);
    }

    @Override
    public List<DomainEtudeDAO> findAll() {
        return domainEtudeServices.findAll();
    }
}
