package com.maxim.shortener.mvc.controller;

import com.maxim.shortener.domain.url.IUrlShortenerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/redirect")
public class RedirectController {
    @Autowired
    IUrlShortenerService shortenerService;
    Logger logger = LoggerFactory.getLogger(RedirectController.class);

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("urls", shortenerService.getShortUrls());
        return "redirect";
    }

    @GetMapping("/{urlKey}")
    @ResponseStatus(HttpStatus.FOUND)
    public void redirectAndLog(@PathVariable String urlKey, HttpServletResponse response) {
        String originalUrl = shortenerService.getOriginalUrl(urlKey);
        response.setHeader("Location", originalUrl);
        response.setStatus(302);
    }
}