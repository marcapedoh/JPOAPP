package com.example.api.services.serviceImpl;


import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.ManifestIntershipDAO;
import com.example.api.dao.OffreOpportuniteDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.models.Observation;
import com.example.api.reporitory.EtudiantRepository;
import com.example.api.reporitory.ManifestInternshipRepository;
import com.example.api.services.ManifestIntershipService;
import com.example.api.validator.EntrepriseValidator;
import com.example.api.validator.ManifestIntershipValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ManifestIntershipServiceImpl implements ManifestIntershipService {
    private ManifestInternshipRepository manifestInternshipRepository;
    private EtudiantRepository etudiantRepository;

    @Autowired
    public ManifestIntershipServiceImpl(ManifestInternshipRepository manifestInternshipRepository, EtudiantRepository etudiantRepository) {
        this.manifestInternshipRepository = manifestInternshipRepository;
        this.etudiantRepository = etudiantRepository;
    }



    @Override
    public ManifestIntershipDAO save(ManifestIntershipDAO manifestIntershipDAO) {
        List<String> errors= ManifestIntershipValidator.validate(manifestIntershipDAO);
        if(!errors.isEmpty()){
            log.warn("manifestion d'interet non valide {}",manifestIntershipDAO);
            throw new InvalidEntityException("la manifestion d'interet n'est pas valide", ErrorCodes.MANIFESTATION_INTERET_NOT_VALID,errors);
        }
        return ManifestIntershipDAO.fromEntity(
                manifestInternshipRepository.save(
                        manifestIntershipDAO.toEntity(manifestIntershipDAO)
                )
        );



    }

    @Override
    public List<ManifestIntershipDAO> findAllManisfestionInteret() {
        return manifestInternshipRepository.findAll().stream()
                .map(ManifestIntershipDAO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Observation validationMnifestation(ManifestIntershipDAO manifestIntershipDAO,boolean validation,String remarque) {
        List<String> errors= ManifestIntershipValidator.validate(manifestIntershipDAO);
        if(!errors.isEmpty()){
            log.warn("manifestion d'interet non valide {}",manifestIntershipDAO);
            throw new InvalidEntityException("la manifestion d'interet n'est pas valide", ErrorCodes.MANIFESTATION_INTERET_NOT_VALID,errors);

        }
        return Observation.builder()
                .acception(validation)
                .motif(remarque)
                .build();
    }


}
