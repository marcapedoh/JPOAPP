package com.example.api.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class DomainEtude extends AbstractEntity{
    private String title;
    @OneToMany(mappedBy = "domainEtude")
    private List<Option> options;
    @OneToMany(mappedBy = "domainEtudeEtud")
    private List<Etudiant> listEtudiant;
}
