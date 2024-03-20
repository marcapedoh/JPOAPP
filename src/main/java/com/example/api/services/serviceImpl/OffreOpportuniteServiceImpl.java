package com.example.api.services.serviceImpl;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.OffreOpportuniteDAO;
import com.example.api.dao.OptionDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.reporitory.DomainEtudeRepository;
import com.example.api.reporitory.EntrepriseRepository;
import com.example.api.reporitory.OffreOpportuniteRepository;
import com.example.api.services.OffreOpportuniteServices;
import com.example.api.validator.EntrepriseValidator;
import com.example.api.validator.OffreOpportuniteValidator;
import com.example.api.validator.OptionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OffreOpportuniteServiceImpl implements OffreOpportuniteServices {
    private OffreOpportuniteRepository offreOpportuniteRepository;
    private EntrepriseRepository entrepriseRepository;
    private DomainEtudeRepository domainEtudeRepository;

    @Autowired
    public OffreOpportuniteServiceImpl(OffreOpportuniteRepository offreOpportuniteRepository, EntrepriseRepository entrepriseRepository, DomainEtudeRepository domainEtudeRepository) {
        this.offreOpportuniteRepository = offreOpportuniteRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.domainEtudeRepository = domainEtudeRepository;
    }


    @Override
    public OffreOpportuniteDAO save(OffreOpportuniteDAO offreOpportuniteDAO) {
        List<String> errors= OffreOpportuniteValidator.validate(offreOpportuniteDAO);
        if(!errors.isEmpty()){
            log.warn("offre d'opportunite non valide {}",offreOpportuniteDAO);
            throw new InvalidEntityException("l'offre d'opportunite n'est pas valide", ErrorCodes.OFFRE_OPPORTINUTE_NOT_VALID,errors);
        }
        return OffreOpportuniteDAO.fromEntity(
                offreOpportuniteRepository.save(
                        OffreOpportuniteDAO.toEntity(offreOpportuniteDAO)
                )
        );
    }

    @Override
    public List<OffreOpportuniteDAO> findByEntreprise(EntrepriseDAO entrepriseDAO) {
        List<String> errors= EntrepriseValidator.validate(entrepriseDAO);
        if(!errors.isEmpty()){
            log.warn("entreprise passé non valide {}",entrepriseDAO);
            throw new InvalidEntityException("entreprise non conforme aux regles", ErrorCodes.ENTREPRISE_NOT_VALID,errors);
        }
        return offreOpportuniteRepository.findOffreOpportuniteByEntreprise(entrepriseDAO).stream()
                .map(OffreOpportuniteDAO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OffreOpportuniteDAO> findByDateDebut(LocalDate date) {
        if(date==null){
            return null;
        }
        return offreOpportuniteRepository.findOffreOpportuniteByDateDebut(date).stream()
                .map(OffreOpportuniteDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
