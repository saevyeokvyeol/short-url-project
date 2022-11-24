package com.shorturl.shorturlproject.dto;

import com.shorturl.shorturlproject.domain.AccessLog;
import com.shorturl.shorturlproject.domain.Url;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLogRequestDto {
    private String ip;
    private String userAgent;
    private String referrer;
    private String shortUrl;
    private Url url;

    public AccessLogRequestDto(String ip, String userAgent, String referrer, String shortUrl) {
        this.ip = ip;
        this.userAgent = userAgent;
        this.referrer = referrer;
        this.shortUrl = shortUrl;
    }

    public AccessLog toEntity() {
        return AccessLog.builder()
                .ip(ip)
                .userAgent(userAgent)
                .referrer(referrer)
                .url(url)
                .build();
    }

    /**
     * url 필드 채우기 용으로 사용
     * */
    public void insertUrl(Url url) {
        this.url = url;
    }
}
