package com.example.api.services.serviceImpl;

import com.example.api.dao.EtudiantDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.models.Etudiant;
import com.example.api.reporitory.EtudiantRepository;
import com.example.api.services.EtudiantServices;
import com.example.api.validator.EtudiantValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantServices {
    private EtudiantRepository etudiantRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, PasswordEncoder passwordEncoder) {
        this.etudiantRepository = etudiantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public EtudiantDAO save(EtudiantDAO etudiantDAO) {
        List<String> errors= EtudiantValidator.validate(etudiantDAO);
        if(!errors.isEmpty()){
            log.error("on ne peut pas enregistrer un etudiant {} qui est vide",etudiantDAO);
            throw new InvalidEntityException("l'etudiant est null ce qui renvoi une entité invalid", ErrorCodes.Utilisateur_Not_Valid,errors);
        }
        if(userAlreadyExists(etudiantDAO.getPhone())) {
            throw new InvalidEntityException("Un autre utilisateur avec le même email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }
        etudiantDAO.setMotDePasse(passwordEncoder.encode(etudiantDAO.getMotDePasse()));
        return EtudiantDAO.fromEntity(
                etudiantRepository.save(
                        EtudiantDAO.toEntity(etudiantDAO)
                )
        );
    }
    private boolean userAlreadyExists(String phone) {
        Optional<Etudiant> user = etudiantRepository.findEtudiantByPhone(phone);
        return user.isPresent();
    }

    @Override
    public EtudiantDAO findById(Integer id) {
        return null;
    }

    @Override
    public List<EtudiantDAO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
