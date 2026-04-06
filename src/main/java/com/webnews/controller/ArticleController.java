package com.webnews.controller;

import com.webnews.entity.Article;
import com.webnews.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller xử lý các request liên quan đến bài viết.
 * Base URL: /api/articles
 */
@RestController
@RequestMapping("/api/articles")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    /**
     * GET /api/articles
     * Lấy tất cả bài viết. Hỗ trợ tìm kiếm theo keyword hoặc lọc theo categoryId.
     */
    @GetMapping
    public ResponseEntity<List<Article>> getAllArticles(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) Long categoryId) {

        List<Article> articles;

        if (keyword != null && !keyword.isBlank()) {
            articles = articleService.searchArticles(keyword);
        } else if (categoryId != null) {
            articles = articleService.getArticlesByCategory(categoryId);
        } else {
            articles = articleService.getAllArticles();
        }

        return ResponseEntity.ok(articles);
    }

    /**
     * GET /api/articles/{id}
     * Lấy bài viết theo ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/articles
     * Tạo bài viết mới.
     */
    @PostMapping
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article saved = articleService.saveArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    /**
     * PUT /api/articles/{id}
     * Cập nhật bài viết theo ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,
                                                  @RequestBody Article article) {
        return articleService.getArticleById(id)
                .map(existing -> {
                    article.setId(id);
                    return ResponseEntity.ok(articleService.saveArticle(article));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/articles/{id}
     * Xóa bài viết theo ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        if (articleService.getArticleById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
