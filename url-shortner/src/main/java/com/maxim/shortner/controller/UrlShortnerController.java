package com.maxim.shortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortnerController {
    @GetMapping("/test")
    public String generate() {
        return "test";
    }
}