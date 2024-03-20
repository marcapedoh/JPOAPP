package com.example.api.validator;

import com.example.api.dao.EntrepriseDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDAO entrepriseDAO){
        List<String> errors= new ArrayList<>();
        if(entrepriseDAO==null){
            errors.add("vous passez une entreprise null");
            errors.add("le mail de l'entreprise en champ important");
            errors.add("le nom de l'entreprise aussi est important");
        }
        assert entrepriseDAO != null;
        if(!StringUtils.hasLength(entrepriseDAO.getMail())){
            errors.add("le mail de l'entreprise en champ important");
        }
        if(!StringUtils.hasLength(entrepriseDAO.getNom())){
            errors.add("le nom de l'entreprise aussi est important");
        }
        return  errors;
    }
}
