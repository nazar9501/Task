package com.simple.app.controller;

import com.simple.app.Enum.Color;
import com.simple.app.model.Articles;
import com.simple.app.model.User;
import com.simple.app.service.ArticlesService;
import com.simple.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    ArticlesService articlesService;

    @PostMapping("/users")
    private int saveUser(@RequestBody User user) {
        userService.save(user);
        return user.getId();
    }

    @GetMapping("/usersByAge/{age}")
    private List<User> getUserByAge(@PathVariable("age") int age) {
        return userService.findUserByAge(age);
    }

    @GetMapping("/usersByColor/{color}")
    private List<User> getUserByColor(@PathVariable("color") Color color) {
        return userService.findUserByColor(color);
    }

    @GetMapping("/usersByArticles")
    private List<User> getUserByArticles() {
        return userService.findUserByArticles();
    }

    @PostMapping("/articles")
    private int saveArticle(@RequestBody Articles articles) {
        articlesService.save(articles);
        return articles.getId();
    }
}
