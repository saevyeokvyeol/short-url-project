package com.shorturl.shorturlproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "access_log_seq")
    @SequenceGenerator(sequenceName = "access_log_seq", allocationSize = 1, name = "access_log_seq")
    private long accessLogId;

    private String ip;
    private String userAgent;
    private String referrer;

    @CreationTimestamp
    private LocalDateTime AccessLogCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Url url;
}
