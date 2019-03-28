package com.simple.app.service;

import com.simple.app.dao.ArticlesRepository;
import com.simple.app.model.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesService {

    @Autowired
    ArticlesRepository articlesRepository;

    public void save(Articles articles) {
        articlesRepository.save(articles);
    }

}
