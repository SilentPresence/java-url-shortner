package com.maxim.shortener.application.url;

import com.maxim.shortener.api.dto.GenerateShortUrlRequest;
import com.maxim.shortener.application.url.generator.ShortUrlKeyGenerator;
import com.maxim.shortener.domain.ip.IIpGetter;
import com.maxim.shortener.domain.url.IUrlShortenerService;
import com.maxim.shortener.domain.url.generator.IShortUrlKeyGenerator;
import com.maxim.shortener.exceptions.BadRequestException;
import com.maxim.shortener.exceptions.InvalidUrlToShortenException;
import com.maxim.shortener.infrastructure.repository.IRedirectLogRepository;
import com.maxim.shortener.infrastructure.repository.IShortenedUrlRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UrlShortenerServiceTest {

    @Mock
    private IShortUrlKeyGenerator generator;
    @Mock
    private IShortenedUrlRepository shortenedUrlRepository;
    @Mock
    private IRedirectLogRepository redirectLogRepository;
    @Mock
    private IIpGetter ipGetter;

    @InjectMocks
    private IUrlShortenerService shortenerService=new UrlShortenerService();

    @Test
    void whenGettingUrlsShouldCallFindAll() {
        shortenerService.getShortUrls();
        Mockito.verify(shortenedUrlRepository,Mockito.times(1)).findAll(Sort.by("createdAt").descending());
    }

    @Test
    void whenCreatingShortUrlWithMissingUrlShouldThrowException() {
        assertThrows(BadRequestException.class,()->shortenerService.generateShortUrl(new GenerateShortUrlRequest("zxc",null)));
    }
    @Test
    void whenCreatingShortUrlWithMissingUserIdShouldThrowException() {
        assertThrows(BadRequestException.class,()->shortenerService.generateShortUrl(new GenerateShortUrlRequest(null,"https://www.google.com")));
    }
    @Test
    void whenCreatingShortUrlWithMalformedUrlShouldThrowException() {
        assertThrows(InvalidUrlToShortenException.class,()->shortenerService.generateShortUrl(new GenerateShortUrlRequest("zxc","https://www.google is")));
    }
}