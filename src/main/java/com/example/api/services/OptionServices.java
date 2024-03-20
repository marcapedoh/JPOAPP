package com.example.api.services;

import com.example.api.dao.OptionDAO;

import java.util.List;

public interface OptionServices {
    OptionDAO save(OptionDAO optionDAO);
    OptionDAO findByTitle(String title);
    List<OptionDAO> findAll();
    void deleteOPtion(Integer id);
}
