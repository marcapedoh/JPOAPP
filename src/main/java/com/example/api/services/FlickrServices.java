package com.example.api.services;

import java.io.InputStream;

public interface FlickrServices {
    String savePhoto(InputStream photo, String title) ;
}
