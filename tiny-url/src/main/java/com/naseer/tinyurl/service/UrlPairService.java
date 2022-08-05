package com.naseer.tinyurl.service;

import java.util.List;

import com.naseer.tinyurl.model.UrlPairModel;
import com.naseer.tinyurl.repository.UrlPairRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlPairService {

    @Autowired
    private UrlPairRepository urlPairRepository;

    public UrlPairModel convertToTiny(String longUrl) {
        if(urlPairRepository.existsByLongUrl(longUrl)) {
            return urlPairRepository.findByLongUrl(longUrl);
        }
        UrlPairModel urlPairModel = new UrlPairModel();
        urlPairModel.setLongUrl(longUrl);
        urlPairRepository.save(urlPairModel);
        String tinyUrl = "tiny-url.org/";
        tinyUrl += urlPairModel.getId().toString();
        urlPairModel.setTinyUrl(tinyUrl);
        return urlPairRepository.save(urlPairModel);
    }

    public UrlPairModel convertToLong(String tinyUrl) {
        if(urlPairRepository.existsByTinyUrl(tinyUrl)) {
            return urlPairRepository.findByTinyUrl(tinyUrl);
        } else {
            UrlPairModel urlPairModel = new UrlPairModel();
            urlPairModel.setTinyUrl(tinyUrl);
            return urlPairModel;
        }
    }

    public List<UrlPairModel> getAllPairs() {
        return urlPairRepository.findAll();
    }
    
}
