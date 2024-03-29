package com.example.shortlink.dao;

import com.example.shortlink.models.Links;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.List;

@Component
public class LinksDao {

    /*private final LinksRepository linksRepository;

    public LinksDao(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    public void saveLink(String shortLink, String longLink){
        Links links = new Links(shortLink, longLink);
        linksRepository.save(links);
    }

    public Links getLink(String shortLink){
        return linksRepository.findByShortLink(shortLink).get(0);
    }*/

    private final SessionFactory sessionFactory;

    @Autowired
    public LinksDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveLink(String shortLink, String longLink) {

        Session session = sessionFactory.getCurrentSession();
        Links links = new Links(shortLink, longLink);

        session.save(links);
    }

    @Transactional(readOnly = true)
    public Links findByShortLink(String shortLink) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT l FROM Links l WHERE l.shortLink = :shortLink");
        query.setParameter("shortLink", shortLink);

        try {
            Links links = (Links) query.getSingleResult();
            return links;
        } catch (NoResultException e) {
            // Если не найдено совпадений, можно вернуть null или бросить исключение
            return null;
        }
    }
}
