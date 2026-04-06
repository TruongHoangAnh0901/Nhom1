package com.congnghevn.newsportal.controller;

import com.congnghevn.newsportal.dto.LoginRequest;
import com.congnghevn.newsportal.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("loginRequest", new LoginRequest());
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest loginRequest, Model model) {
        if (authService.login(loginRequest)) {
            return "redirect:/news";
        }
        model.addAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng");
        return "auth/login";
    }
}