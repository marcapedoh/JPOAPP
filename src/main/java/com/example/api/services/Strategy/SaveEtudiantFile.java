package com.example.api.services.Strategy;

import com.example.api.dao.EtudiantDAO;
import com.example.api.exceptions.ErrorCodes;
import com.example.api.exceptions.InvalidOperationException;
import com.example.api.services.EtudiantServices;
import com.example.api.services.FlickrServices;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("EtudiantStrategy")
@Slf4j
public class SaveEtudiantFile implements Strategy<EtudiantDAO>{

    private final FlickrServices flickrServices;
    private final EtudiantServices etudiantServices;

    @Autowired
    public SaveEtudiantFile(FlickrServices flickrServices, EtudiantServices etudiantServices) {
        this.flickrServices = flickrServices;
        this.etudiantServices = etudiantServices;
    }

    @Override
    public EtudiantDAO saveFile(Integer id, InputStream file, String titre) throws FlickrException {
        EtudiantDAO etudiantDAO= etudiantServices.findById(id);
        String urlFile= flickrServices.savePhoto(file,titre);
        if(!StringUtils.hasLength(urlFile)){
            throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'article", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        etudiantDAO.setPhoto(urlFile);
        return etudiantServices.save(etudiantDAO) ;
    }
}
