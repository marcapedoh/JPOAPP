package com.example.api.validator;

import com.example.api.dao.ManifestIntershipDAO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ManifestIntershipValidator {

    public static List<String> validate(ManifestIntershipDAO manifestIntershipDAO){
        List<String> errors= new ArrayList<>();

        if(manifestIntershipDAO==null){
            errors.add("vous fournissez une manisfestion vide");
        }
        assert manifestIntershipDAO != null;
        if(!StringUtils.hasLength(manifestIntershipDAO.getCv())){
            errors.add("le cv est important que tout");
        }
        return errors;
    }
}
