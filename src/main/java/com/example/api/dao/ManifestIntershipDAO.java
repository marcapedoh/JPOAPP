package com.example.api.dao;

import com.example.api.models.Etudiant;
import com.example.api.models.ManifestIntership;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManifestIntershipDAO {
    private EtudiantDAO etudiant;
    private String cv;
    private String lettreMotivation;
    private String lettreDeRecommandation;

    public static ManifestIntershipDAO fromEntity(ManifestIntership manifestIntership){
        if(manifestIntership==null){
            return null;
        }
        return ManifestIntershipDAO.builder()
                .etudiant(EtudiantDAO.fromEntity(manifestIntership.getEtudiant()))
                .cv(manifestIntership.getCv())
                .lettreMotivation(manifestIntership.getLettreMotivation())
                .lettreDeRecommandation(manifestIntership.getLettreDeRecommandation())
                .build();
    }

    public static  ManifestIntership toEntity(ManifestIntershipDAO manifestIntershipDAO){
        if(manifestIntershipDAO==null){
            return  null;
        }
        ManifestIntership manifestIntership= new ManifestIntership();
        manifestIntership.setEtudiant(EtudiantDAO.toEntity(manifestIntershipDAO.getEtudiant()));
        manifestIntership.setCv(manifestIntershipDAO.getCv());
        manifestIntership.setLettreMotivation(manifestIntershipDAO.getLettreMotivation());
        manifestIntership.setLettreDeRecommandation(manifestIntershipDAO.getLettreDeRecommandation());
        return manifestIntership;
    }
}
