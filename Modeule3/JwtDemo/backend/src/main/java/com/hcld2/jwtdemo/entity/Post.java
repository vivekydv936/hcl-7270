package com.hcld2.jwtdemo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(length = 2000)
    private  String content;

    private String author;

    private LocalDateTime createdAt= LocalDateTime.now();

    protected Post() {
    }

    public Post(Object title, Object content, String name) {
        this.title = (String) title;
        this.content = (String) content;
        this.author = name;
    }


        public Object getTitle() {
        return title;
       
    }

    public Object getContent() {
        return content;
    }
}