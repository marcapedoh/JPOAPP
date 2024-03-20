package com.example.api.controller.API;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.ManifestIntershipDAO;
import com.example.api.dao.OffreOpportuniteDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;

@Api(APP_ROOT+"/entreprise/")
public interface OffreOpportuniteAPI {
    @PostMapping(value = APP_ROOT + "/entreprise/OffreOpportunite/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une manifestion d'interet", notes=" cette methode permet d'enregistrer et modifier une manifestion d'interet ",response = OffreOpportuniteDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object manifestion d'interet a ete bien crée ou modifer")
    })
    OffreOpportuniteDAO save(@RequestBody OffreOpportuniteDAO offreOpportuniteDAO);
    @GetMapping(value = APP_ROOT+"/entreprise/OffreOpportunite/findByEntreprise",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des offres d'opportunités", notes="cette methode permet de rechercher une opportunité avec tous ses attributs",responseContainer = "List<OffreOpportuniteDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des offres d'opportunites/liste vide")
    })
    List<OffreOpportuniteDAO> findByEntreprise(@RequestBody EntrepriseDAO entrepriseDAO);
    @GetMapping(value = APP_ROOT+"/entreprise/OffreOpportunite/findByDateDebut/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des offres d'opportunités", notes="cette methode permet de rechercher une opportunité avec tous ses attributs",responseContainer = "List<OffreOpportuniteDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des offres d'opportunites/liste vide")
    })
    List<OffreOpportuniteDAO> findByDateDebut(@PathVariable("date") LocalDate date);
}
