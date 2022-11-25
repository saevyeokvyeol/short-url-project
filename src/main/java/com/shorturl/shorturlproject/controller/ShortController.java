package com.shorturl.shorturlproject.controller;

import com.shorturl.shorturlproject.dto.UrlRequestDto;
import com.shorturl.shorturlproject.dto.UrlDetailResponseDto;
import com.shorturl.shorturlproject.dto.UrlResponseDto;
import com.shorturl.shorturlproject.exception.InvalidLoginInformationException;
import com.shorturl.shorturlproject.exception.UrlNotFoundException;
import com.shorturl.shorturlproject.service.ShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class ShortController {
    private final ShortService shortService;

    /**
     * url 생성 페이지
     * : 원본 url을 입력하면 short url을 생성한 뒤 해당 short url의 디테일 페이지로 이동함
     *
     * @param: UrlRequestDto urlRequestDto
     * @return: String(생성한 shortUrl을 이용해 디테일 페이지로 리다이렉트)
     * */
    @PostMapping("/url")
    public String createUrl(@RequestBody UrlRequestDto urlRequestDto, HttpSession session) {
        String shortUrl = shortService.createUrl(urlRequestDto);
        session.setAttribute(shortUrl, shortUrl);
        return shortUrl;
    }

    /**
     * 인증
     * : 인증 페이지에서 받은 비밀번호로 인증 시도 후 성공 시 세션에 저장
     *
     * @param: UrlRequestDto urlRequestDto
     * */
    @PostMapping("/authenticate")
    public void authenticateUrl(@RequestBody UrlRequestDto urlRequestDto, HttpSession session) throws UrlNotFoundException, InvalidLoginInformationException {
        UrlResponseDto urlResponseDto = shortService.authenticateUrl(urlRequestDto);
        session.setAttribute(urlResponseDto.getShortUrl(), urlResponseDto.getShortUrl());
    }
}