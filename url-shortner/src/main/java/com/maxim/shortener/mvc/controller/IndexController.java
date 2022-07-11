package com.maxim.shortener.mvc.controller;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.domain.url.IUrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String index() {
        return "index";
    }
}