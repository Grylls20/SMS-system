package com.meesho.smssystem.controller;

import com.meesho.smssystem.model.MessageLog;
import com.meesho.smssystem.repository.MessageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/messages")
public class MessageLogController {
    @Autowired
    private MessageLogRepository messageLogRepository;

    @GetMapping
    public List<MessageLog> getAllMessages() {
        return messageLogRepository.findAll();
    }
}
