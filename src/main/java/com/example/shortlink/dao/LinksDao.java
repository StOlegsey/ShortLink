package com.example.shortlink.dao;

import com.example.shortlink.models.Links;
import com.example.shortlink.repositories.LinksRepository;
import org.springframework.stereotype.Component;

@Component
public class LinksDao {

    private final LinksRepository linksRepository;

    public LinksDao(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public void saveLink(String shortLink, String longLink){
        Links links = new Links(shortLink, longLink);
        linksRepository.save(links);
    }
}
