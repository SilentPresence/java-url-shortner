package com.maxim.shortener.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "url")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortenedUrl implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, name = "url_key", nullable = false)
    private String urlKey;
    @Column(nullable = false)
    private String url;
    @Column(nullable = false, name = "user_id")
    private String userId;
    @Column(nullable = false, name = "created_at")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
