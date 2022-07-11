package com.maxim.shortener.application.logs;

import com.maxim.shortener.domain.logs.IRedirectLogService;
import com.maxim.shortener.exceptions.UrlKeyNotFound;
import com.maxim.shortener.infrastructure.model.RedirectLog;
import com.maxim.shortener.infrastructure.repository.IRedirectLogRepository;
import com.maxim.shortener.infrastructure.repository.IShortenedUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RedirectLogService implements IRedirectLogService {

    @Autowired
    IRedirectLogRepository repository;
    @Autowired
    IShortenedUrlRepository urlRepository;

    @Override
    public List<RedirectLog> getLogs(String urlKey) {
        if (urlRepository.getShortenedUrlByUrlKey(urlKey) == null) {
            throw new UrlKeyNotFound();
        }
        return repository.getEventsByShortenedUrl(urlKey);
    }
}
