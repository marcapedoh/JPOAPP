package com.example.api.controller;

import com.example.api.controller.API.PhotoAPI;
import com.example.api.services.Strategy.StrategyFileContext;
import com.flickr4java.flickr.FlickrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class PhotoController implements PhotoAPI {
    private StrategyFileContext strategyFileContext;

    @Autowired
    public PhotoController(StrategyFileContext strategyPhotoConextext) {
        this.strategyFileContext = strategyPhotoConextext;
    }

    @Override
    public Object saveFile(String context, Integer id, @RequestParam("file") MultipartFile file, String title) throws IOException, FlickrException {
        return strategyFileContext.saveFile(context, id, file.getInputStream(), title);
    }
}