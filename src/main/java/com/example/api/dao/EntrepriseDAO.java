package com.example.api.dao;

import com.example.api.models.Entreprise;
import com.example.api.models.OffreOpportunite;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EntrepriseDAO {
    private String nom;
   private String mail;
    private String photo;
    private String motDePasse;
    @JsonIgnore
    private List<OffreOpportunite> list;

    public static EntrepriseDAO fromEntity(Entreprise entreprise){
        if(entreprise==null){
            return null;
        }
        return EntrepriseDAO.builder()
                .nom(entreprise.getNom())
                .mail(entreprise.getMail())
                .photo(entreprise.getPhoto())
                .motDePasse(entreprise.getMotDePasse())
                .build();
    }
    public static Entreprise toEntity(EntrepriseDAO entrepriseDAO){
        if(entrepriseDAO==null){
            return null;
        }
        Entreprise entreprise= new Entreprise();
        entreprise.setNom(entrepriseDAO.getNom());
        entreprise.setPhoto(entrepriseDAO.getPhoto());
        entreprise.setMail(entrepriseDAO.getMail());
        entreprise.setMotDePasse(entrepriseDAO.getMotDePasse());
        return entreprise;
    }
}
