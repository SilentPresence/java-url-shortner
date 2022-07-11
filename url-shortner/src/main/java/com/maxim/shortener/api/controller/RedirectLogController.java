package com.maxim.shortener.api.controller;

import com.maxim.shortener.domain.logs.IRedirectLogService;
import com.maxim.shortener.infrastructure.model.RedirectLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class RedirectLogController {
    @Autowired
    IRedirectLogService redirectLogService;

    @GetMapping("/{urlKey}")
    @ResponseStatus(HttpStatus.OK)
    public List<RedirectLog> getLogs(@PathVariable String urlKey) {
        return redirectLogService.getLogs(urlKey);
    }
}