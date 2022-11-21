package com.shorturl.shorturlproject.repository;

import com.shorturl.shorturlproject.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, String> {
}
