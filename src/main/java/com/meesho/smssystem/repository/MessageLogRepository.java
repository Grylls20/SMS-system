package com.meesho.smssystem.repository;

import com.meesho.smssystem.model.MessageLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageLogRepository extends JpaRepository<MessageLog, Long> {
}
