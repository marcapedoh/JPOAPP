package com.example.api.validator;

import com.example.api.dao.DomainEtudeDAO;

import java.util.ArrayList;
import java.util.List;

public class DomainEtudeValidator {

    public static List<String> validate(DomainEtudeDAO domainEtudeDAO){
        List<String> errors= new ArrayList<>();
        if(domainEtudeDAO==null){
            errors.add("vous passez un domainEtude null!");
            errors.add("les options sont obligatoires");
        }
        assert domainEtudeDAO != null;
        if(domainEtudeDAO.getOptions()==null){
            errors.add("les options sont obligatoires");
        }
        return errors;
    }
}
