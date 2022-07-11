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
@Table(name = "events")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RedirectLog implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(name = "url", referencedColumnName = "url_key")
    @ManyToOne
    private ShortenedUrl shortenedUrl;
    @Column(nullable = false)
    private String ip;
    @Column(nullable = false, name = "redirected_at")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date redirectedAt;
}
