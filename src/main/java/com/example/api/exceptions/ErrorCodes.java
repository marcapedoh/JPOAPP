package com.example.api.exceptions;

public enum ErrorCodes {
    UPDATE_PHOTO_EXCEPTION(1000),
    Utilisateur_Not_Valid(1001),
    UTILISATEUR_ALREADY_EXISTS(1002);

    private Integer code;
    ErrorCodes(Integer code){
        this.code=code;
    }
    public Integer getCode(){
        return code;
    }

    }
