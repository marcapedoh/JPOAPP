package com.example.api.services.serviceImpl;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.exceptions.EntityNotFoundException;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.models.Entreprise;
import com.example.api.reporitory.EntrepriseRepository;
import com.example.api.services.EntrepriseServices;
import com.example.api.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseServices {
    private EntrepriseRepository entrepriseRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository,PasswordEncoder passwordEncoder) {
        this.entrepriseRepository = entrepriseRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public EntrepriseDAO save(EntrepriseDAO entrepriseDAO) {
        List<String> errors= EntrepriseValidator.validate(entrepriseDAO);
        if(!errors.isEmpty()){
            log.error("on ne peut pas enregistrer une entreprise {} qui est vide",entrepriseDAO);
            throw new InvalidEntityException("l'entreprise est null ce qui renvoi une entité invalid", ErrorCodes.Utilisateur_Not_Valid,errors);
        }
        if(userAlreadyExists(entrepriseDAO.getMail())) {
            throw new InvalidEntityException("Une autre entreprise avec le même email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Une autre entreprise avec le meme email existe deja dans la BDD"));
        }
        entrepriseDAO.setMotDePasse(passwordEncoder.encode(entrepriseDAO.getMotDePasse()));
        return EntrepriseDAO.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDAO.toEntity(entrepriseDAO)
                )
        );
    }
    private boolean userAlreadyExists(String email) {
        Optional<Entreprise> user = entrepriseRepository.findEntrepriseByMail(email);
        return user.isPresent();
    }
    @Override
    public EntrepriseDAO findById(Integer id) {
        if(id==null){
            return null;
        }
        Optional<Entreprise> entreprise= entrepriseRepository.findById(id);
        return entreprise.map(EntrepriseDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucune entreprise trouvé pour cet id"));
    }

    @Override
    public List<EntrepriseDAO> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDAO::fromEntity)
                .collect(Collectors.toList());
    }


}
