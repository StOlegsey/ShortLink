package com.example.shortlink.repositories;

import com.example.shortlink.models.Links;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinksRepository extends CrudRepository<Links, Integer> {
}
