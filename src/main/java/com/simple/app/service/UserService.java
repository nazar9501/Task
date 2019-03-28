package com.simple.app.service;

import com.simple.app.Enum.Color;
import com.simple.app.dao.UserRepository;
import com.simple.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findUserByAge(int age) {
        return userRepository.findUserByAge(age);
    }

    public List<User> findUserByColor(Color color) {
        return userRepository.findUserByColor(color);
    }

    public List<User> findUserByArticles() {
        return userRepository.findUserByArticles();
    }

}
