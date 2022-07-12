package com.maxim.shortener.infrastructure.repository;


import com.maxim.shortener.infrastructure.model.ShortenedUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IShortenedUrlRepository extends JpaRepository<ShortenedUrl, Long> {
    ShortenedUrl getShortenedUrlByUrlKey(String urlKey);
}
