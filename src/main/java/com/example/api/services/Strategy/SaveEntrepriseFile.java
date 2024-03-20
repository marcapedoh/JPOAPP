package com.example.api.services.Strategy;

import com.example.api.dao.EntrepriseDAO;
import com.example.api.dao.EtudiantDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidOperationException;
import com.example.api.services.EntrepriseServices;
import com.example.api.services.FlickrServices;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("EntrepriseStrategy")
@Slf4j
public class SaveEntrepriseFile implements Strategy<EntrepriseDAO>{
    private final FlickrServices flickrServices;
    private final EntrepriseServices entrepriseServices;

    @Autowired
    public SaveEntrepriseFile(FlickrServices flickrServices, EntrepriseServices entrepriseServices) {
        this.flickrServices = flickrServices;
        this.entrepriseServices = entrepriseServices;
    }

    @Override
    public EntrepriseDAO saveFile(Integer id, InputStream file, String titre) throws FlickrException {
        EntrepriseDAO entrepriseDAO= entrepriseServices.findById(id);
        String urlFile= flickrServices.savePhoto(file,titre);
        if(!StringUtils.hasLength(urlFile)){
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'article", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        entrepriseDAO.setPhoto(urlFile);
        return entrepriseServices.save(entrepriseDAO) ;
    }
}
