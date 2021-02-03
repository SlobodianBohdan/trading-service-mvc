package com.trading.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @PostMapping(path = "/trade/admin/logout")
    public String logout() {
        SecurityContextHolder.clearContext();
        return "main/home";
    }
}
