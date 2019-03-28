package com.simple.app.dao;

import com.simple.app.model.Articles;
import org.springframework.data.repository.CrudRepository;

public interface ArticlesRepository extends CrudRepository<Articles, Integer> {
}
