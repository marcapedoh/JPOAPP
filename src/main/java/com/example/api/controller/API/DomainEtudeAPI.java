package com.example.api.controller.API;

import com.example.api.dao.DomainEtudeDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"entreprise")
public interface DomainEtudeAPI {
    @PostMapping(value = APP_ROOT +"entreprise/domainEtude/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un domaine d'etude", notes=" cette methode permet d'enregistrer et modifier un domaine d'étude",response = DomainEtudeDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object domaineEtude a ete bien crée ou modifer")
    })
    DomainEtudeDAO save(@RequestBody DomainEtudeDAO domainEtudeDAO);
    @GetMapping(value = APP_ROOT+"entreprise/domainEtude/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des domaineEtudes", notes=" cette methode permet de rechercher un domaine d'étude avec tous ses attributs",responseContainer = "List<DomainEtudeDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des domaineEtude/liste vide")
    })
    List<DomainEtudeDAO> findAll();
}
