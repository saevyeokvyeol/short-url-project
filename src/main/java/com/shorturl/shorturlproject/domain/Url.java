package com.shorturl.shorturlproject.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Url {
    @Id
    private String shortUrl;

    @NonNull
    private String destinationUrl;

    @NonNull
    private long totalClick = 0;

    @NonNull
    private String password;

    @CreationTimestamp
    private LocalDateTime urlCreateDate;

    @UpdateTimestamp
    private LocalDateTime lastClickDate;

    @OneToMany(mappedBy = "url")
    @JsonIgnore
    private List<AccessLog> accessLogList;

    /**
     * short url 만들기
     * : 알파벳 대소문자와 숫자로 이루어진 7자리의 short url을 생성해 shortUrl 필드에 입력
     * */
    public void createShortUrl() {

    }

    /**
     * 조회수 카운트
     * : 조회수 필드인 totalClick를 1씩 카운트
     * */
    public void plusTotalClick() {

    }
}
