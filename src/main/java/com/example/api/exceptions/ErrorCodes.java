package com.example.api.exceptions;

public enum ErrorCodes {
    UPDATE_PHOTO_EXCEPTION(1000),
    Utilisateur_Not_Valid(1001),
    UTILISATEUR_ALREADY_EXISTS(1002),
    OPTION_NOT_VALID(1003),
    OFFRE_OPPORTINUTE_NOT_VALID(1004),
    ENTREPRISE_NOT_VALID(1005),
    DOMAINETUDE_INVALID(1006),
    MANIFESTATION_INTERET_NOT_VALID(1006);

    private Integer code;
    ErrorCodes(Integer code){
        this.code=code;
    }
    public Integer getCode(){
        return code;
    }

    }
