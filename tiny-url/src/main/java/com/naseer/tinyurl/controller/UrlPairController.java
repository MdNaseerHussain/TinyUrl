package com.naseer.tinyurl.controller;

import java.util.List;

import com.naseer.tinyurl.model.UrlPairModel;
import com.naseer.tinyurl.service.UrlPairService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UrlPairController {

    @Autowired
    private UrlPairService urlPairService;

    @GetMapping("/getTiny")
    // {/getTiny/longUrl} => (@PathVariable String longUrl)
    public UrlPairModel getTiny(@RequestParam("url") String longUrl) {
        return urlPairService.convertToTiny(longUrl);
    }

    @GetMapping("/getLong")
    public UrlPairModel getLong(@RequestParam("url") String tinyUrl) {
        return urlPairService.convertToLong(tinyUrl);
    }

    @GetMapping("/admin")
    public List<UrlPairModel> getAllPairs() {
        return urlPairService.getAllPairs();
    }

}
