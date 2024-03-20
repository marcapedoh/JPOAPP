package com.example.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Internship")
@EqualsAndHashCode(callSuper = true)
public class OffreOpportunite extends AbstractEntity{
    @Column(name = "description",nullable = false)
    private String conditionsDePostulation;
    @Column(name = "dateDebut",nullable = false)
    private Instant dateDebut;
    @Column(name = "dateFin",nullable = false)
    private Instant cloturePostulation;
    @Column(name = "placePromus",nullable = false)
    private Integer placePromus;
    @ManyToOne
    @JoinColumn(name="idEntreprise")
    private Entreprise entreprise;
    @ManyToOne
    @JoinColumn(name = "idDomainEtude")
    private DomainEtude domainEtudeOffr;
}
