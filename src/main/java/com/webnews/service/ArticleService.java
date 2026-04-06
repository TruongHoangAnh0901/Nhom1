package com.webnews.service;

import com.webnews.entity.Article;
import com.webnews.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service xử lý business logic cho bài viết.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleRepository articleRepository;

    /**
     * Lấy tất cả bài viết.
     */
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    /**
     * Tìm bài viết theo ID.
     */
    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    /**
     * Lấy danh sách bài viết theo danh mục.
     */
    public List<Article> getArticlesByCategory(Long categoryId) {
        return articleRepository.findByCategoryId(categoryId);
    }

    /**
     * Tìm kiếm bài viết theo từ khóa trong tiêu đề.
     */
    public List<Article> searchArticles(String keyword) {
        return articleRepository.findByTitleContainingIgnoreCase(keyword);
    }

    /**
     * Tạo mới hoặc cập nhật bài viết.
     */
    @Transactional
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    /**
     * Xóa bài viết theo ID.
     */
    @Transactional
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
