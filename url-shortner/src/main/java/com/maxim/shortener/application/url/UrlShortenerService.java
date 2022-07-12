package com.maxim.shortener.application.url;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.domain.ip.IIpGetter;
import com.maxim.shortener.domain.url.IUrlShortenerService;
import com.maxim.shortener.domain.url.generator.IShortUrlKeyGenerator;
import com.maxim.shortener.domain.url.validator.UrlValidatorUtils;
import com.maxim.shortener.exceptions.BadRequestException;
import com.maxim.shortener.exceptions.InvalidUrlToShortenException;
import com.maxim.shortener.exceptions.UrlKeyNotFound;
import com.maxim.shortener.infrastructure.model.RedirectLog;
import com.maxim.shortener.infrastructure.model.ShortenedUrl;
import com.maxim.shortener.infrastructure.repository.IRedirectLogRepository;
import com.maxim.shortener.infrastructure.repository.IShortenedUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UrlShortenerService implements IUrlShortenerService {
    @Autowired
    IShortUrlKeyGenerator urlKeyGenerator;
    @Autowired
    IShortenedUrlRepository urlRepository;
    @Autowired
    IRedirectLogRepository logRepository;
    @Autowired
    IIpGetter ipGetter;

    @Override
    public String generateShortUrl(GenerateShortUrlRequest request) {
        if (request.url() == null) {
            throw new BadRequestException("Url is required");
        }
        if (!UrlValidatorUtils.isValid(request.url())) {
            throw new InvalidUrlToShortenException();
        }
        if (request.userId() == null) {
            throw new BadRequestException("User id is required");
        }
        String newUrlKey = urlKeyGenerator.generateShortUrlKey(request.url(), request.userId(), new Date().getTime());
        ShortenedUrl shortenedUrl = ShortenedUrl.builder()
                .urlKey(newUrlKey)
                .url(request.url())
                .userId(request.userId())
                .build();
        urlRepository.save(shortenedUrl);
        return newUrlKey;
    }

    @Override
    public List<ShortenedUrl> getShortUrls() {
        return urlRepository.findAll(Sort.by("createdAt").descending());
    }

    @Override
    public String getOriginalUrl(String urlKey) {
        ShortenedUrl shortenedUrl = urlRepository.getShortenedUrlByUrlKey(urlKey);
        if (shortenedUrl == null) {
            throw new UrlKeyNotFound();
        }
        RedirectLog log = RedirectLog.builder()
                .ip(ipGetter.getCurrentUserIp())
                .shortenedUrl(shortenedUrl).build();
        logRepository.save(log);
        return shortenedUrl.getUrl();
    }
}
