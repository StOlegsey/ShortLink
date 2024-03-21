package com.example.shortlink.services;

import com.example.shortlink.dao.LinksDao;
import com.example.shortlink.models.Links;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
public class ShortApiService {

    private final LinksDao linksDao;

    public ShortApiService(LinksDao linksDao) {
        this.linksDao = linksDao;
    }

    public String shortenLink(String longLink) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLink = generator.generate(7);

        linksDao.saveLink(randomLink, longLink);

        return randomLink;
    }
}
