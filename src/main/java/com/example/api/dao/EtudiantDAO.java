package com.example.api.dao;


import com.example.api.models.Etudiant;
import com.example.api.models.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EtudiantDAO {
    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNais;
    private String phone;
    private Gender gender;
    private String photo;
    private String motDePasse;
    private DomainEtudeDAO domainEtudeEtud;

    public static EtudiantDAO fromEntity(Etudiant etudiant){
        if(etudiant==null){
            return  null;
        }
        return EtudiantDAO.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .gender(etudiant.getGender())
                .dateNais(etudiant.getDateNais())
                .photo(etudiant.getPhoto())
                .phone(etudiant.getPhone())
                .motDePasse(etudiant.getMotDePasse())
                .domainEtudeEtud(DomainEtudeDAO.fromEntity(etudiant.getDomainEtudeEtud()))
                .build();
    }

    public static Etudiant toEntity(EtudiantDAO etudiantDAO){
        if(etudiantDAO==null){
            return null;
        }
        Etudiant etudiant= new Etudiant();
        etudiant.setId(etudiantDAO.getId());
        etudiant.setNom(etudiantDAO.getNom());
        etudiant.setPrenom(etudiantDAO.getPrenom());
        etudiant.setGender(etudiantDAO.getGender());
        etudiant.setDateNais(etudiantDAO.getDateNais());
        etudiant.setPhoto(etudiantDAO.getPhoto());
        etudiant.setPhone(etudiantDAO.getPhone());
        etudiant.setMotDePasse(etudiantDAO.getMotDePasse());
        etudiant.setDomainEtudeEtud(DomainEtudeDAO.toEntity(etudiantDAO.getDomainEtudeEtud()));
        return etudiant;
    }
}
