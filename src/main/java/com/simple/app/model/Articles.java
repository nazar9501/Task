package com.simple.app.model;

import com.simple.app.Enum.Color;

import javax.persistence.*;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "articleID")
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    public Articles() {

    }

    public Articles(String text, Color color, User user) {
        this.user = user;
        this.text = text;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
