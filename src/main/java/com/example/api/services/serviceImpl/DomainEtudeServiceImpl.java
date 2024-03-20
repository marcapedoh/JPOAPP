package com.example.api.services.serviceImpl;

import com.example.api.dao.DomainEtudeDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.reporitory.DomainEtudeRepository;
import com.example.api.services.DomainEtudeServices;
import com.example.api.validator.DomainEtudeValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
 @Slf4j
public class DomainEtudeServiceImpl implements DomainEtudeServices {
     private DomainEtudeRepository domainEtudeRepository;

     @Autowired
     public DomainEtudeServiceImpl(DomainEtudeRepository domainEtudeRepository) {
         this.domainEtudeRepository = domainEtudeRepository;
     }

     @Override
    public DomainEtudeDAO save(DomainEtudeDAO domainEtudeDAO) {
         List<String> errors= DomainEtudeValidator.validate(domainEtudeDAO);
         if(!errors.isEmpty()){
             log.error("on ne peut pas enregistrer un domaine d'etude {} qui est vide",domainEtudeDAO);
             throw new InvalidEntityException("vous fournissez un domaine d'étude invalid", ErrorCodes.DOMAINETUDE_INVALID,errors);
         }

        return DomainEtudeDAO.fromEntity(
                domainEtudeRepository.save(
                        DomainEtudeDAO.toEntity(domainEtudeDAO)
                )
        );
    }

    @Override
    public List<DomainEtudeDAO> findAll() {
        return domainEtudeRepository.findAll().stream()
                .map(DomainEtudeDAO::fromEntity)
                .collect(Collectors.toList());
    }
}
