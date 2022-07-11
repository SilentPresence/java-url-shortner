package com.maxim.shortener.api.controller;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.domain.url.IUrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/shortener")
public class UrlShortenerController {
    @Autowired
    IUrlShortenerService shortenerService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public String generate(@RequestBody GenerateShortUrlRequest request) {
        return shortenerService.generateShortUrl(request);
    }

    @GetMapping("/{urlKey}")
    @ResponseStatus(HttpStatus.FOUND)
    public void redirectAndLog(@PathVariable String urlKey, HttpServletResponse response) {
        String originalUrl = shortenerService.getOriginalUrl(urlKey);
        response.setHeader("Location", originalUrl);
        response.setStatus(302);
    }
}