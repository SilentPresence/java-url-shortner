package com.maxim.shortener.application.url.generator;

import com.maxim.shortener.domain.url.generator.IShortUrlKeyGenerator;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Locale;

@Component
public class ShortUrlKeyGenerator implements IShortUrlKeyGenerator {
    @Override
    public String generateShortUrlKey(String url, String userId, long timestamp) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
            String text = String.join(";", url, userId.toLowerCase(Locale.ROOT), String.valueOf(timestamp));
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String generateShortUrlKey(String url, String userId) {
        return generateShortUrlKey(url, userId, 0);
    }
}
