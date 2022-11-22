package com.shorturl.shorturlproject.controller;

import com.shorturl.shorturlproject.dto.UrlRequestDto;
import com.shorturl.shorturlproject.service.ShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ShortController {
    private final ShortService shortService;

    /**
     * url 생성 페이지
     * : 원본 url을 입력하면 short url을 생성한 뒤 해당 short url의 디테일 페이지로 이동함
     *
     * @param: Url url(shortUrl, password)
     * @return: String(생성한 shortUrl을 이용해 디테일 페이지로 리다이렉트)
     * */
    @PostMapping("/create-url")
    public UrlRequestDto createUrl(UrlRequestDto url) {
        return null;
    }
}
