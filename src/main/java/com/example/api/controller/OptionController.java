package com.example.api.controller;

import com.example.api.controller.API.OptionServicesAPI;
import com.example.api.dao.OptionDAO;
import com.example.api.services.OptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OptionController implements OptionServicesAPI {
    private OptionServices optionServices;

    @Autowired
    public OptionController(OptionServices optionServices) {
        this.optionServices = optionServices;
    }

    @Override
    public OptionDAO save(OptionDAO optionDAO) {
        return optionServices.save(optionDAO);
    }

    @Override
    public OptionDAO findByTitle(String title) {
        return optionServices.findByTitle(title);
    }

    @Override
    public List<OptionDAO> findAll() {
        return optionServices.findAll();
    }

    @Override
    public void deleteOPtion(Integer id) {
        optionServices.deleteOPtion(id);
    }
}
