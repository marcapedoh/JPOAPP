package com.example.api.services;

import com.example.api.dao.EtudiantDAO;

import java.util.List;

public interface EtudiantServices {
    EtudiantDAO save(EtudiantDAO etudiantDAO);
    EtudiantDAO findById(Integer id);
    List<EtudiantDAO> findAll();
}