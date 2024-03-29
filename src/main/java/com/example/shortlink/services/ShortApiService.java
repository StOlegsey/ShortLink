package com.example.shortlink.services;

import com.example.shortlink.dao.LinksDao;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShortApiService {

    @PostConstruct
    public void init(){
        log.info("ShortApiService is constructing");
    }

    private final LinksDao linksDao;

    public ShortApiService(LinksDao linksDao) {
        this.linksDao = linksDao;
    }

    public String getShortLink(String longLink) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z').build();
        String randomLink = generator.generate(7);

        linksDao.saveLink(randomLink, longLink);

        return randomLink;
    }

    public String getFullLink(String shortLink){
        return linksDao.findByShortLink(shortLink).getLongLink();
    }
}
