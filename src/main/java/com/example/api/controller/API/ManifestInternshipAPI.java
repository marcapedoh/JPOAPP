package com.example.api.controller.API;

import com.example.api.dao.EtudiantDAO;
import com.example.api.dao.ManifestIntershipDAO;
import com.example.api.models.Observation;
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

@Api(APP_ROOT+"/etudiant/")
public interface ManifestInternshipAPI {
    @PostMapping(value = APP_ROOT + "/etudiant/manifestInternship/create", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "enregistrer une manifestion d'interet", notes=" cette methode permet d'enregistrer et modifier une manifestion d'interet ",response = ManifestIntershipDAO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "l'object manifestion d'interet a ete bien crée ou modifer")
    })
    ManifestIntershipDAO save(@RequestBody ManifestIntershipDAO manifestIntershipDAO);
    @GetMapping(value = APP_ROOT+"/etudiant/manisfestInternship/findAllManisfestionInteret",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des manifestInternship", notes="cette methode permet de rechercher une manifestation d'interet avec tous ses attributs",responseContainer = "List<ManifestIntershipDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des manifestInternship/liste vide")
    })
    List<ManifestIntershipDAO> findAllManisfestionInteret();
    @GetMapping(value = APP_ROOT+"/entreprise/manisfestInternship/validationMnifestation/{acception}/{remarque}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des manifestInternship", notes="cette methode permet de rechercher une manifestation d'interet avec tous ses attributs",responseContainer = "List<ManifestIntershipDAO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "liste des manifestInternship/liste vide")
    })
    Observation validationMnifestation(@RequestBody ManifestIntershipDAO manifestIntershipDAO, @PathVariable("acception") boolean acception,@PathVariable("remarque") String remarque);
}
