package com.congnghevn.newsportal.repository;

import com.congnghevn.newsportal.entity.NewsArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsArticle, Long> {
}