package com.example.api.services;

import com.example.api.dao.DomainEtudeDAO;

import java.util.List;

public interface DomainEtudeServices {
    DomainEtudeDAO save(DomainEtudeDAO domainEtudeDAO);
    List<DomainEtudeDAO> findAll();

}
