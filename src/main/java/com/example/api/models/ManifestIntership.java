package com.example.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class ManifestIntership extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idEtudiant")
    private Etudiant etudiant;
    @Column(name = "cv",nullable = false,unique = true)
    private String cv;
    @Column(name = "lettreMotivation",nullable = false)
    private String lettreMotivation;
    @Column(name = "lettreDeRecommandation",nullable = false)
    private String lettreDeRecommandation;

}
