package com.shorturl.shorturlproject.controller;

import com.shorturl.shorturlproject.domain.AccessLog;
import com.shorturl.shorturlproject.dto.AccessLogRequestDto;
import com.shorturl.shorturlproject.dto.UrlResponseDto;
import com.shorturl.shorturlproject.exception.UrlNotFoundException;
import com.shorturl.shorturlproject.service.ShortService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String redirectShortUrl(@PathVariable("shortUrl") String shortUrl, HttpServletRequest request) throws UrlNotFoundException {
        System.out.println(shortUrl);
        String ip = this.getClientIp(request);
        String userAgent = request.getHeader("user-agent");
        String referrer = request.getHeader("Referer");

        AccessLogRequestDto accessLogRequestDto = AccessLogRequestDto.builder()
                .ip(ip)
                .userAgent(userAgent)
                .referrer(referrer)
                .shortUrl(shortUrl)
                .build();

        return "redirect:" + shortService.clickShortUrl(accessLogRequestDto);
    }

    /**
     * 클라이언트 ip 가져오기
     *
     * @param: HttpServletRequest request(클라이언트 ip를 가져올 HttpServletRequest 입력)
     * @return: String(가져온 ip 리턴)
     * */
    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("WL-Proxy-Client-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_CLIENT_IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("X-RealIP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getHeader("REMOTE_ADDR");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) ip = request.getRemoteAddr();

        return ip;
    }

    /**
     * 디테일 페이지
     * : shortUrl로 Url을 검색해 Url과 AccessLog 정보 조회
     *
     * @param: String shortUrl(PathVariable을 이용해 파라미터를 받아옴)
     * @return: String(detail.jsp로 이동)
     * */
    @GetMapping("/{shortUrl}/detail")
    public String detailUrl(@PathVariable("shortUrl") String shortUrl, Model model) throws UrlNotFoundException {
        UrlResponseDto urlResponseDto = shortService.detailUrl(shortUrl);
        model.addAttribute("url", urlResponseDto);
        return "detail";
    }
}
