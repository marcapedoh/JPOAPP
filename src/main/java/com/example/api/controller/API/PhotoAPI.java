package com.example.api.controller.API;

import com.flickr4java.flickr.FlickrException;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static codeFusion.IntershipAPI.IntershipApplicationAPI.utils.Constants.APP_ROOT;


@Api(APP_ROOT+"/photo")
public interface PhotoAPI {
    @PostMapping(APP_ROOT+"/photo/saveFile/{id}/{titre}/{context}")
    Object saveFile(@PathVariable("context") String context, @PathVariable("id") Integer id, @RequestPart("file") MultipartFile file,@PathVariable("titre") String title) throws IOException, FlickrException;
}