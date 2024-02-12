package com.example.repository;

import com.example.template.MyNamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MessageRepository {

    private final MyNamedParameterJdbcTemplate jdbcTemplate;

    public MessageRepository(MyNamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getMessage() {
        return jdbcTemplate.queryForString("SELECT message FROM message");
    }

    public void saveMessage(String message) {
        jdbcTemplate.update("INSERT INTO message (message) VALUES (:message)", Map.of("message", message));
    }
}
