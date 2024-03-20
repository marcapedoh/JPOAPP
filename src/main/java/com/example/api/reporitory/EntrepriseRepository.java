package com.example.api.reporitory;

import com.example.api.models.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {
    Optional<Entreprise> findEntrepriseByMail(String mail);
}
