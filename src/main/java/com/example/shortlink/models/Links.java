package com.example.shortlink.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Links {

    @Id
    @Column(name = "shortlink")
    private String shortLink;

    @Column(name = "longlink")
    private String longLink;

    public Links() {

    }

    public Links(String shortLink, String longLink) {
        this.shortLink = shortLink;
        this.longLink = longLink;
    }
}
