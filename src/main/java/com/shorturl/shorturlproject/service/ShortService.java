package com.shorturl.shorturlproject.service;

import com.shorturl.shorturlproject.domain.AccessLog;
import com.shorturl.shorturlproject.domain.Url;

public interface ShortService {
    /**
     * Url 생성
     * : url 생성 시 url 내부 메소드 호출해 short url 생성
     *
     * @param: Url url(destinationUrl, password)
     * */
    void createUrl(Url url);

    /**
     * AccessLog 생성 및 Url 조회수 증가
     * : 1. A
     * : short url을 이용해 원본 url로 이동할 때 메소드 호출
     *
     * @param: AccessLog accessLog(ip, userAgent, referrer, url(shortUrl))
     * @return: Url url(Url의 destinationUrl을 이용해 redirect시키기 위해 리턴)
     * */
    Url clickShortUrl(AccessLog accessLog);

    /**
     * id를 이용해 Url 가져오기
     * : short url 상세 정보를 조회하기 위해 메소드 호출
     *
     * @param: Url url(shortUrl, password)
     * @return: Url url
     * */
    Url detailUrl(Url url);
}
