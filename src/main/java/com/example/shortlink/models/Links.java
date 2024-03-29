package com.example.shortlink.models;

import javax.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "links")
@Getter
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
