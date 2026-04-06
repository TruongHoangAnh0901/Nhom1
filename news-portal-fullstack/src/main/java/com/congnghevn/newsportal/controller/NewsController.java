package com.congnghevn.newsportal.controller;

import com.congnghevn.newsportal.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/news")
    public String listNews(Model model) {
        model.addAttribute("newsList", newsRepository.findAll()); // Lấy toàn bộ tin tức [cite: 13]
        return "news/index";
    }
}