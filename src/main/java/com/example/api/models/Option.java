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
public class Option extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "idDomainEtude")
    private DomainEtude domainEtude;
    @Column(name = "title",nullable = false)
    private String title;
}
