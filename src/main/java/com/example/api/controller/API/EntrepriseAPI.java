package com.example.api.controller.API;

import com.example.api.dao.DomainEtudeDAO;
import com.example.api.dao.EntrepriseDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"entreprise/")
public interface EntrepriseAPI {
    @PostMapping(value = APP_ROOT + "entreprise/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une entreprise", notes=" cette methode permet d'enregistrer et modifier une entreprise",response = EntrepriseDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object domaineEtude a ete bien crée ou modifer")
    })
    EntrepriseDAO save(@RequestBody EntrepriseDAO entrepriseDAO);
    @GetMapping(value = APP_ROOT+"entreprise/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une entreprise", notes=" cette methode permet de rechercher une entreprise par son ID",response = EntrepriseDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'entreprise a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucune entreprise n'est trouvé dans la base de donnée")
    })
    EntrepriseDAO findById(@PathVariable("id") Integer id);
    @GetMapping(value = APP_ROOT+"entreprise/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des entreprises", notes=" cette methode permet de rechercher une entreprise avec tous ses attributs",responseContainer = "List<EntrepriseDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des entreprises/liste vide")
    })
    List<EntrepriseDAO> findAll();
}
