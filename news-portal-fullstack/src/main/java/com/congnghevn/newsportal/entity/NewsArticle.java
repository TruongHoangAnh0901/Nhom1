package com.congnghevn.newsportal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String content;
    private String author;
    private String category;
}