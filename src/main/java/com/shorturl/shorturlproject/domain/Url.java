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
    private long totalClick;

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
     * 조회수 카운트
     * : 조회수 필드인 totalClick를 1씩 카운트
     * */
    public void plusTotalClick() {
        this.totalClick++;
    }
}
