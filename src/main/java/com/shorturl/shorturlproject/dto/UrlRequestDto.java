package com.shorturl.shorturlproject.dto;

import com.shorturl.shorturlproject.domain.Url;
import lombok.*;

@Getter
@NoArgsConstructor
public class UrlRequestDto {
    private String shortUrl;
    private String destinationUrl;
    private String password;

    @Builder
    public UrlRequestDto(String destinationUrl, String password) {
        this.destinationUrl = destinationUrl;
        this.password = password;
    }

    public Url toEntity() {
        return Url.builder()
                .shortUrl(shortUrl)
                .destinationUrl(destinationUrl)
                .totalClick(0)
                .password(password)
                .build();
    }

    /**
     * short url 만들기
     * : 알파벳 대소문자와 숫자로 이루어진 7자리의 short url을 생성해 shortUrl 필드에 입력
     * */
    public void createShortUrl() {

    }
}
