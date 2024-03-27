package com.example.api.services.serviceImpl;

import com.example.api.dao.OptionDAO;
import com.example.api.exceptions.EntityNotFoundException;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidEntityException;
import com.example.api.models.Option;
import com.example.api.reporitory.DomainEtudeRepository;
import com.example.api.reporitory.OptionRepository;
import com.example.api.services.OptionServices;
import com.example.api.validator.OptionValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class OptionServiceImpl implements OptionServices {
    private OptionRepository optionRepository;
    @Autowired
    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }
    @Override
    public OptionDAO save(OptionDAO optionDAO) {
        List<String> errors= OptionValidator.validate(optionDAO);
        if(!errors.isEmpty()){
            log.warn("option non valide {}",optionDAO);
            throw new InvalidEntityException("l'option n'est pas valide", ErrorCodes.OPTION_NOT_VALID,errors);
        }

        return OptionDAO.fromEntity(
                optionRepository.save(
                        OptionDAO.toEntity(optionDAO)
                )
        );
    }

    @Override
    public OptionDAO findByTitle(String title) {
        if(!StringUtils.hasLength(title)){
            log.error("vous ne pouvez chercher une option si vous ne renseigné pas les iinformations");
            return null;
        }
        Optional<Option> option= optionRepository.findOptionByTitle(title);
        return option.map(OptionDAO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("aucune option n'est trouvé pour ce titre!"));
    }

    @Override
    public List<OptionDAO> findAll() {
        return optionRepository.findAll().stream()
                .map(OptionDAO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOPtion(Integer id) {
        if(id==null){
            return;
        }

        optionRepository.deleteById(id);
    }
}
