package com.shorturl.shorturlproject.repository;

import com.shorturl.shorturlproject.domain.AccessLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessLogRepository extends JpaRepository<AccessLog, Long> {
}
