package com.example.api.reporitory;

import com.example.api.dao.EtudiantDAO;
import com.example.api.models.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

    Optional<Etudiant> findEtudiantByPhone(String phone);
}
