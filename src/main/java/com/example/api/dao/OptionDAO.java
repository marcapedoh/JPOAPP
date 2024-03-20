package com.example.api.dao;

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
    @JsonIgnore
    private DomainEtudeDAO domainEtude;
    private String title;

    public static OptionDAO fromEntity(Option option){
        if(option==null){
            return null;
        }
        return OptionDAO.builder()

                .title(option.getTitle())
                .build();
    }

    public static Option toEntity(OptionDAO optionDAO){
        if(optionDAO==null){
            return null;
        }
        Option option= new Option();

        option.setTitle(optionDAO.getTitle());
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
                    .domainEtude(DomainEtudeDAO.fromEntity(element.getDomainEtude()))
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
                    .domainEtude(DomainEtudeDAO.toEntity(element.getDomainEtude()))
                    .build());
        }
        return list;
    }


}
