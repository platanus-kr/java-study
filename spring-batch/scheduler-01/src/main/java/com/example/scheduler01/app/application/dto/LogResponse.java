package com.example.scheduler01.app.application.dto;


import com.example.scheduler01.app.domain.Log;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
public class LogResponse {
    private long sequence;
    private String body;
    private LocalDateTime created;

    public static List<LogResponse> from(List<Log> logs) {
        if (logs.size() < 1) {
            return new ArrayList<>();
        }
        List<LogResponse> responses = new ArrayList<>();
        long sequence = 0;
        for (Log log : logs) {
            LogResponse build = LogResponse.builder().sequence(sequence).body(log.getBody()).created(log.getCreated()).build();
            responses.add(build);
        }
        return responses;
    }
}
