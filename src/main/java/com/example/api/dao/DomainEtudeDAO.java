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
    private List<OptionDAO> options;
    @JsonIgnore
    private List<EtudiantDAO> listEtudiant;
    @JsonIgnore
    private List<OffreOpportuniteDAO> listOffre;


    public static DomainEtudeDAO fromEntity(DomainEtude domainEtude){
        if(domainEtude==null){
            return null;
        }
        return DomainEtudeDAO.builder()
                .options(OptionDAO.fromEntityList(domainEtude.getOptions()))
                .build();
    }
    public  static  DomainEtude toEntity(DomainEtudeDAO domainEtudeDAO){
        if(domainEtudeDAO==null){
            return  null;
        }
        DomainEtude domainEtude= new DomainEtude();
        domainEtude.setOptions(OptionDAO.toEntityList(domainEtudeDAO.getOptions()));

        return domainEtude;
    }



}
