package com.example.shortlink.controllers;

import com.example.shortlink.ShortLinkApplication;
import com.example.shortlink.services.ShortApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final ShortApiService shortApiService;

    public RestController(ShortApiService shortApiService) {
        this.shortApiService = shortApiService;
    }

    @GetMapping("/getShortLink/{fullLink}")
    public String testGet(@PathVariable String fullLink){
        return ("your link: "+fullLink+"\nnew link: "+shortApiService.shortenLink(fullLink));
    }
}
