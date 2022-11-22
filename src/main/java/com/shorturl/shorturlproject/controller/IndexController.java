package com.shorturl.shorturlproject.controller;

import com.shorturl.shorturlproject.service.ShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final ShortService shortService;

    /**
     * 메인 페이지
     * @return: String(index.jsp로 이동)
     * */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 리다이렉트 페이지
     * : shortUrl로 Url을 검색해 원본 url로 리다이렉트
     *
     * @param: String shortUrl(PathVariable을 이용해 파라미터를 받아옴)
     * @return: String(파라미터로 받아온 shortUrl로 검색한 원본 url로 리다이렉트)
     * */
    @GetMapping("/{shortUrl}")
    public String redirectShortUrl(@PathVariable String shortUrl) {
        return "error";
    }

    /**
     * 디테일 페이지
     * : shortUrl로 Url을 검색해 Url과 AccessLog 정보 조회
     *
     * @param: String shortUrl(PathVariable을 이용해 파라미터를 받아옴)
     * @return: String(detail.jsp로 이동)
     * */
    @GetMapping("/{shortUrl}/detail")
    public String detailUrl(@PathVariable String shortUrl) {
        return "detail";
    }
}
