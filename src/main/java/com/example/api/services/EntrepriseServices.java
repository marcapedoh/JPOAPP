package com.example.api.services;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.EtudiantDAO;

import java.util.List;

public interface EntrepriseServices {
    EntrepriseDAO save(EntrepriseDAO entrepriseDAO);
    EntrepriseDAO findById(Integer id);
    List<EntrepriseDAO> findAll();
    void delete(Integer id);
}
