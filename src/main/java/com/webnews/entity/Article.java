package com.webnews.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity đại diện cho bài viết trong hệ thống WEBNEWS.
 */
@Data
@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "thumbnail_url", length = 1000)
    private String thumbnailUrl;

    @Column(name = "category_id")
    private Long categoryId;
}
