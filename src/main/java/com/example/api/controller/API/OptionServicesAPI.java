package com.example.api.controller.API;

import com.example.api.dao.OffreOpportuniteDAO;
import com.example.api.dao.OptionDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/entreprise/")
public interface OptionServicesAPI {
    @PostMapping(value = APP_ROOT + "/entreprise/Option/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une Option", notes=" cette methode permet d'enregistrer et modifier une option  ",response = OptionDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object option a ete bien crée ou modifer")
    })
    OptionDAO save(OptionDAO optionDAO);
    @GetMapping(value = APP_ROOT + "/entreprise/Option/findByTitle/{title}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une option", notes=" cette methode permet de rechercher une option par son code",response = OptionDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'option a ete trouvé dans la base de donnée"),
            @ApiResponse(code=400,message = "aucun option n'est trouvé dans la base de donnée")
    })
    OptionDAO findByTitle(@PathVariable("title") String title);
    @GetMapping(value = APP_ROOT+"/entreprise/Option/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des offres d'option", notes="cette methode permet de rechercher une option avec tous ses attributs",responseContainer = "List<OptionDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des options/liste vide")
    })
    List<OptionDAO> findAll();
    @DeleteMapping(value = APP_ROOT+"/entreprise/delete/{id}")
    void deleteOPtion(@PathVariable("id") Integer id);
}
