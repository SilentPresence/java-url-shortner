package com.maxim.shortener.application.logs;

import com.maxim.shortener.domain.logs.IRedirectLogService;
import com.maxim.shortener.infrastructure.model.RedirectLog;
import com.maxim.shortener.infrastructure.repository.IRedirectLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedirectLogService implements IRedirectLogService {

    @Autowired
    IRedirectLogRepository repository;

    @Override
    public List<RedirectLog> getLogs(String urlKey) {
        return repository.getEventsByShortenedUrl(urlKey);
    }
}
