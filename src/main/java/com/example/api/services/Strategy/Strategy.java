package com.example.api.services.Strategy;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface Strategy<T> {
    T saveFile(Integer id, InputStream file, String titre) throws FlickrException;
}
