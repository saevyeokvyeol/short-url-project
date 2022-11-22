package com.shorturl.shorturlproject.controller;

import com.shorturl.shorturlproject.domain.Url;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShortController {

    /**
     * 메인 페이지
     * : 원본 url을 입력하면 short url을 생성한 뒤 해당 short url의 디테일 페이지로 이동함
     *
     * @param: Url url(shortUrl, password)
     * @return: String(생성한 shortUrl을 이용해 디테일 페이지로 리다이렉트)
     * */
    @RequestMapping("/")
    public String index(Url url) {
        return "index";
    }

    /**
     * 리다이렉트 페이지
     * : shortUrl로 Url을 검색해 원본 url로 리다이렉트
     *
     * @param: String shortUrl(PathVariable을 이용해 파라미터를 받아옴)
     * @return: String(파라미터로 받아온 shortUrl로 검색한 원본 url로 리다이렉트)
     * */
    @RequestMapping("/{shortUrl}")
    public String redirectShortUrl(@PathVariable String shortUrl) {
        return "error";
    }

    /**
     * 디테일 페이지
     * : shortUrl로 Url을 검색해 Url과 AccessLog 정보 조회
     *
     * @
     * */
    @RequestMapping("/{shortUrl}/detail")
    public String detailUrl(@PathVariable String shortUrl) {
        return "detail";
    }
}
