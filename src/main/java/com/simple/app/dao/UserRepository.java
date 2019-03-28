package com.simple.app.dao;

import com.simple.app.Enum.Color;
import com.simple.app.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Transactional
    @Query("SELECT u.name, u.age FROM User u " +
            "WHERE u.age = :age")
    List<User> findUserByAge(@Param("age") int age);

    @Transactional
    @Query("SELECT u.name FROM User u " +
            "INNER JOIN Articles a " +
            "ON u.id = a.user " +
            "WHERE a.color = :color " +
            "GROUP BY u.id")
    List<User> findUserByColor(@Param("color") Color color);

    @Transactional
    @Query("SELECT u.name FROM User u " +
            "LEFT JOIN Articles a " +
            "ON u.id = a.user " +
            "GROUP BY u.name " +
            "HAVING COUNT(a.id) > 3")
    List<User> findUserByArticles();

}
