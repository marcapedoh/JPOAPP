package com.example.api.dao;

import com.example.api.models.OffreOpportunite;
import com.example.api.models.Option;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionDAO{
    private  Integer id;
    private DomainEtudeDAO domainEtude;

    @JsonIgnore
    private List<OffreOpportunite> listOffres;
    private String title;

    public static OptionDAO fromEntity(Option option){
        if(option==null){
            return null;
        }
        return OptionDAO.builder()
                .id(option.getId())
                .title(option.getTitle())
                .domainEtude(DomainEtudeDAO.fromEntity(option.getDomainEtude()))
                .build();
    }

    public static Option toEntity(OptionDAO optionDAO){
        if(optionDAO==null){
            return null;
        }
        Option option= new Option();
        option.setId(optionDAO.getId());
        option.setTitle(optionDAO.getTitle());
        option.setDomainEtude(DomainEtudeDAO.toEntity(optionDAO.getDomainEtude()));
        return option;
    }
    public static List<OptionDAO> fromEntityList(List<Option> options){
        if(options==null){
            return null;
        }
        List<OptionDAO> list=new ArrayList<>();
        for (Option element: options) {
            list.add(OptionDAO.builder()
                    .title(element.getTitle())
                    .build());
        }
        return list;
    }

    public static List<Option> toEntityList(List<OptionDAO> options){
        if(options==null){
            return null;
        }
        List<Option> list=new ArrayList<>();
        for (OptionDAO element: options) {
            list.add(Option.builder()
                    .title(element.getTitle())
                    .build());
        }
        return list;
    }


}
