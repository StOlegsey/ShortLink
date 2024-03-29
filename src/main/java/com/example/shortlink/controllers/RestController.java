package com.example.shortlink.controllers;

import com.example.shortlink.services.ShortApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestController {

    private final ShortApiService shortApiService;

    public RestController(ShortApiService shortApiService) {
        this.shortApiService = shortApiService;
    }

    @GetMapping("/getShortLink/{fullLink}")
    public ResponseEntity<?> linkGet(@PathVariable String fullLink) {
        try {
            String shortLink = shortApiService.getShortLink(fullLink);
            return new ResponseEntity<>(("your link: " + fullLink + "\nnew link: " + shortLink), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/openShortLink/{shortLink}")
    public ModelAndView redirectToUrl(@PathVariable String shortLink) {
        String fullLink = shortApiService.getFullLink(shortLink);
        String redirectUrl = "redirect:https://www." + fullLink;

        return new ModelAndView(redirectUrl);
    }
    @GetMapping("/justTest")
    public ResponseEntity<?> testGet() {

            return new ResponseEntity<>("I'm alive", HttpStatus.OK);
    }
}
