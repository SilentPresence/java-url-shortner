package com.maxim.shortener.mvc.controller;

import com.maxim.shortener.domain.logs.IRedirectLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    IRedirectLogService redirectLogService;
    Logger logger = LoggerFactory.getLogger(LogsController.class);

    @GetMapping("/{urlKey}")
    public String index(Model model, @PathVariable String urlKey) {
        model.addAttribute("logs", redirectLogService.getLogs(urlKey));
        return "logs";
    }
}