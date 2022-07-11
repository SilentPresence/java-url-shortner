package com.maxim.shortener.bl;

import com.maxim.shortener.domain.url.generator.IShortUrlKeyGenerator;
import com.maxim.shortener.application.url.generator.ShortUrlKeyGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortUrlKeyGeneratorTest {

    @Test
    void shouldGenerateKey() {
        IShortUrlKeyGenerator generator = new ShortUrlKeyGenerator();
        String key = generator.generateShortUrlKey("https://www.google.com", "silent");
        assertNotNull(key);
    }

    @Test
    void shouldGenerateDifferentKeyWhenDifferentUser() {
        IShortUrlKeyGenerator generator = new ShortUrlKeyGenerator();
        String key1 = generator.generateShortUrlKey("https://www.google.com", "silent");
        String key2 = generator.generateShortUrlKey("https://www.google.com", "presence");
        assertNotEquals(key1, key2);
    }

    @Test
    void shouldGenerateDifferentKeyWhenDifferentUrl() {
        IShortUrlKeyGenerator generator = new ShortUrlKeyGenerator();
        String key1 = generator.generateShortUrlKey("https://www.google.com", "silent");
        String key2 = generator.generateShortUrlKey("https://www.yahoo.com", "silent");
        assertNotEquals(key1, key2);
    }
    @Test
    void shouldGenerateSameKeyWhenAllSame() {
        IShortUrlKeyGenerator generator = new ShortUrlKeyGenerator();
        String key1 = generator.generateShortUrlKey("https://www.google.com", "silent", 1);
        String key2 = generator.generateShortUrlKey("https://www.google.com", "silent", 1);
        assertEquals(key1, key2);
    }
    @Test
    void shouldGenerateDifferentKeyWhenDifferentTimestamp() {
        IShortUrlKeyGenerator generator = new ShortUrlKeyGenerator();
        String key1 = generator.generateShortUrlKey("https://www.google.com", "silent", 1);
        String key2 = generator.generateShortUrlKey("https://www.google.com", "silent", 2);
        assertNotEquals(key1, key2);
    }
}