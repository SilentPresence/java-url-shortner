package com.maxim.shortener.mvc.controller;

import com.maxim.shortener.domain.url.IUrlShortenerService;
import com.maxim.shortener.mvc.dto.GenerateShortUrlFormData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/generate")
public class ShortenerController {
    @Autowired
    IUrlShortenerService shortenerService;
    Logger logger = LoggerFactory.getLogger(ShortenerController.class);

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("request", new GenerateShortUrlFormData("qwerty", "https://www.google.com"));
        return "create";
    }

    @PostMapping()
    public String generate(@ModelAttribute GenerateShortUrlFormData request) {
        shortenerService.generateShortUrl(request.toRequest());
        return "redirect:/generate";
    }
}