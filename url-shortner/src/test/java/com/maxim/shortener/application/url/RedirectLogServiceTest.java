package com.maxim.shortener.application.url;

import com.maxim.shortener.application.logs.RedirectLogService;
import com.maxim.shortener.domain.logs.IRedirectLogService;
import com.maxim.shortener.exceptions.BadRequestException;
import com.maxim.shortener.exceptions.UrlKeyNotFound;
import com.maxim.shortener.infrastructure.model.ShortenedUrl;
import com.maxim.shortener.infrastructure.repository.IRedirectLogRepository;
import com.maxim.shortener.infrastructure.repository.IShortenedUrlRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RedirectLogServiceTest {

    @Mock
    private IShortenedUrlRepository shortenedUrlRepository;
    @Mock
    private IRedirectLogRepository redirectLogRepository;
    @InjectMocks
    private IRedirectLogService redirectLogService = new RedirectLogService();


    @Test
    void whenUrlKeyDoesNotExistThrowException() {
        String key = "123";
        Mockito.when(shortenedUrlRepository.getShortenedUrlByUrlKey(key)).thenReturn(null);
        assertThrows(UrlKeyNotFound.class, () -> redirectLogService.getLogs(key));
    }


    @Test
    void whenUrlKeyExistFindAllLogs() {
        String key = "123";
        Mockito.when(shortenedUrlRepository.getShortenedUrlByUrlKey(key)).thenReturn(new ShortenedUrl());

        redirectLogService.getLogs(key);

        Mockito.verify(redirectLogRepository, Mockito.times(1)).getEventsByShortenedUrl(key);
    }
}