package com.webnews.repository;

import com.webnews.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository cho Article, kế thừa JpaRepository để có sẵn các CRUD methods.
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Tìm bài viết theo danh mục
    List<Article> findByCategoryId(Long categoryId);

    // Tìm bài viết theo từ khóa trong tiêu đề (case-insensitive)
    List<Article> findByTitleContainingIgnoreCase(String keyword);
}
