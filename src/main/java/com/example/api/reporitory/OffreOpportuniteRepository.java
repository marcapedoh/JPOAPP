package com.example.api.reporitory;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.models.Entreprise;
import com.example.api.models.OffreOpportunite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OffreOpportuniteRepository extends JpaRepository<OffreOpportunite,Integer> {
    List<OffreOpportunite> findOffreOpportuniteByEntreprise(EntrepriseDAO entreprise);
    List<OffreOpportunite> findOffreOpportuniteByDateDebut(LocalDate date);
}
