package com.maxim.shortener.infrastructure.repository;


import com.maxim.shortener.infrastructure.model.RedirectLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IRedirectLogRepository extends JpaRepository<RedirectLog, Long> {
    @Query(value = "SELECT * FROM events e where e.url=:shortenedUrl ORDER BY redirected_at DESC", nativeQuery = true)
    List<RedirectLog> getEventsByShortenedUrl(String shortenedUrl);
}
