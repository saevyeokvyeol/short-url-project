package com.shorturl.shorturlproject.dto;

import com.shorturl.shorturlproject.domain.Url;
import lombok.*;

import javax.persistence.Entity;

@Getter
@NoArgsConstructor
public class UrlRequestDto {
    private String shortUrl;
    private String destinationUrl;
    private String password;

    @Builder
    public UrlRequestDto(String shortUrl, String destinationUrl, String password) {
        this.shortUrl = shortUrl;
        this.destinationUrl = destinationUrl;
        this.password = password;
    }

    public Url toEntity() {
        return Url.builder()
                .shortUrl(this.shortUrl)
                .destinationUrl(this.destinationUrl)
                .totalClick(0)
                .password(this.password)
                .build();
    }

    /**
     * short url 만들기
     * : 알파벳 대소문자와 숫자로 이루어진 7자리의 short url을 생성해 shortUrl 필드에 입력
     * */
    public void createShortUrl() {
        String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        int len = key.length();

        while (stringBuilder.length() < 7) {
            int split = (int) (Math.random() * len);
            stringBuilder.append(key.substring(split, split + 1));
        }

        this.shortUrl = stringBuilder.toString();
    }
}
