package com.example.api.validator;

import com.example.api.dao.EtudiantDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EtudiantValidator {

    public static List<String> validate(EtudiantDAO etudiantDAO){
        List<String> errors= new ArrayList<>();
        if(etudiantDAO==null){
            errors.add("vous passez un etudiant null");
            errors.add("le nom de l'etudiant est obligatoire");
        }
        assert etudiantDAO != null;
        if(!StringUtils.hasLength(etudiantDAO.getNom())){
            errors.add("le nom de l'etudiant est obligatoire");
        }
        return errors;
    }
}
