package com.maxim.shortener.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shortener")
public class UrlShortenerController {
    @GetMapping("/test")
    public String generate() {
        return "test";
    }
}