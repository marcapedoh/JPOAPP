package com.example.api.services.Strategy;

import com.flickr4java.flickr.FlickrException;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Objects;

@Service
public class StrategyFileContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    public  StrategyFileContext(BeanFactory beanFactory){
        this.beanFactory=beanFactory;
    }

    public Object saveFile(String context, Integer id, InputStream file, String title) throws FlickrException {
        determinContext(context);
        return strategy.saveFile(id,file,title);
    }
    private void determinContext(String context){
        final String beanName=context+"Strategy";

        if(Objects.equals(context, "etablissement")){
            strategy= beanFactory.getBean(beanName,SaveEtudiantFile.class);
        }
    }
}
