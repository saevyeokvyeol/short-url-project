package com.shorturl.shorturlproject.dto;

import com.shorturl.shorturlproject.domain.AccessLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccessLogResponseDto {
    private long accessLogId;
    private String ip;
    private String userAgent;
    private String referrer;
    private LocalDateTime AccessLogCreateDate;
    private UrlRequestDto url;

    public AccessLogResponseDto(AccessLog entity) {
        this.accessLogId = entity.getAccessLogId();
        this.ip = entity.getIp();
        this.userAgent = entity.getUserAgent();
        this.AccessLogCreateDate = entity.getAccessLogCreateDate();
    }
}
