package com.example.api.controller.API;

import com.example.api.dao.DomainEtudeDAO;
import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.EtudiantDAO;
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

@Api(APP_ROOT+"etudiant/")
public interface EtudiantAPI {
    @PostMapping(value = APP_ROOT + "etudiant/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer un etudiant", notes=" cette methode permet d'enregistrer et modifier un étudiant ",response = EtudiantDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object domaineEtude a ete bien crée ou modifer")
    })
    EtudiantDAO save(@RequestBody EtudiantDAO etudiantDAO);
    @GetMapping(value = APP_ROOT+"etudiant/findById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un etudiant", notes=" cette methode permet de rechercher une entreprise par son ID",response = EtudiantDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'etudiant a ete trouvé dans la base de donnée"),
            @ApiResponse(code=404,message = "aucun étudiant n'est trouvé dans la base de donnée")
    })
    EtudiantDAO findById(@PathVariable("id") Integer id);
    @GetMapping(value = APP_ROOT+"etudiant/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des etudiants", notes="cette methode permet de rechercher un etudiant avec tous ses attributs",responseContainer = "List<EtudiantDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des Etudiants/liste vide")
    })
    List<EtudiantDAO> findAll();

}
