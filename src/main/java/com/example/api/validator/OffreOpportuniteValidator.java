package com.example.api.validator;

import com.example.api.dao.OffreOpportuniteDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class OffreOpportuniteValidator {

    public static List<String> validate(OffreOpportuniteDAO offreOpportuniteDAO){
        List<String> errors= new ArrayList<>();

        if(offreOpportuniteDAO==null){
            errors.add("vous essayez de creer une offre d'opportunite/stage mais les informations ne sont recupérés");
        }
        assert offreOpportuniteDAO != null;
        if(!StringUtils.hasLength(offreOpportuniteDAO.getConditionsDePostulation())){
            errors.add("les conditions de candidateur sont importante");
        }
        return errors;
    }
}
