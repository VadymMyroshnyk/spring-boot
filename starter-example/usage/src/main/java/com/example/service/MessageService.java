package com.example.service;

import com.example.repository.MessageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class MessageService implements CommandLineRunner {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void run(String... args) {
        messageRepository.saveMessage("Hello, World!");
        System.out.println(messageRepository.getMessage());
    }
}
