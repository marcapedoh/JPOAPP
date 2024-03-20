package com.example.api.dao;

import com.example.api.models.DomainEtude;
import com.example.api.models.Entreprise;
import com.example.api.models.OffreOpportunite;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OffreOpportuniteDAO {
    private String conditionsDePostulation;
    private Instant dateDebut;
    private Instant cloturePostulation;
    private Integer placePromus;
    private EntrepriseDAO entreprise;
    private DomainEtudeDAO domainEtudeOffr;

    public static OffreOpportuniteDAO fromEntity(OffreOpportunite offreOpportunite){
        if(offreOpportunite==null){
            return null;
        }
        return OffreOpportuniteDAO.builder()
                .conditionsDePostulation(offreOpportunite.getConditionsDePostulation())
                .dateDebut(Instant.now())
                .cloturePostulation(offreOpportunite.getCloturePostulation())
                .placePromus(offreOpportunite.getPlacePromus())
                .entreprise(EntrepriseDAO.fromEntity(offreOpportunite.getEntreprise()))
                .domainEtudeOffr(DomainEtudeDAO.fromEntity(offreOpportunite.getDomainEtudeOffr()))
                .build();
    }

    public static OffreOpportunite toEntity(OffreOpportuniteDAO offreOpportuniteDAO){
        if(offreOpportuniteDAO==null){
            return null;
        }
        OffreOpportunite offreOpportunite=new OffreOpportunite();
        offreOpportunite.setConditionsDePostulation(offreOpportuniteDAO.getConditionsDePostulation());
        offreOpportunite.setDateDebut(offreOpportuniteDAO.getDateDebut());
        offreOpportunite.setCloturePostulation(offreOpportuniteDAO.getCloturePostulation());
        offreOpportunite.setPlacePromus(offreOpportuniteDAO.getPlacePromus());
        offreOpportunite.setEntreprise(EntrepriseDAO.toEntity(offreOpportuniteDAO.getEntreprise()));
        offreOpportunite.setDomainEtudeOffr(DomainEtudeDAO.toEntity(offreOpportuniteDAO.getDomainEtudeOffr()));
        return offreOpportunite;
    }
}
