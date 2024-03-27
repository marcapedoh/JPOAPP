package com.example.api.dao;

import com.example.api.models.DomainEtude;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DomainEtudeDAO {
    private Integer id;
    private String title;
    @JsonIgnore
    private List<OptionDAO> options;
    @JsonIgnore
    private List<EtudiantDAO> listEtudiant;


    public static DomainEtudeDAO fromEntity(DomainEtude domainEtude){
        if(domainEtude==null){
            return null;
        }
        return DomainEtudeDAO.builder()
                .id(domainEtude.getId())
                .title(domainEtude.getTitle())
                .build();
    }
    public  static  DomainEtude toEntity(DomainEtudeDAO domainEtudeDAO){
        if(domainEtudeDAO==null){
            return  null;
        }
        DomainEtude domainEtude= new DomainEtude();
        domainEtude.setId(domainEtudeDAO.getId());
        domainEtude.setTitle(domainEtudeDAO.getTitle());
        return domainEtude;
    }



}
