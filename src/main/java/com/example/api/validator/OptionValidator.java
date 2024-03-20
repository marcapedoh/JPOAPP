package com.example.api.validator;

import com.example.api.dao.OptionDAO;
import org.springframework.util.StringUtils;


import java.util.ArrayList;
import java.util.List;

public class OptionValidator {

    public static List<String> validate(OptionDAO optionDAO){
        List<String> errors= new ArrayList<>();
        if(optionDAO==null){
            errors.add("vous passez un objet vide!");
            errors.add("vous devez fournir le titre de l'option");
        }
        assert optionDAO != null;
        if(!StringUtils.hasLength(optionDAO.getTitle())){
            errors.add("vous devez fournir le titre de l'option");
        }
        return errors;
    }
}
