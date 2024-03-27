package com.example.api.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Option extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idDomainEtude")
    private DomainEtude domainEtude;
    @Column(name = "title",nullable = false,unique = true)
    private String title;
    @OneToMany(mappedBy = "option")
    private List<OffreOpportunite> listOffres;
}
