package com.example.scheduler01.app.application.dto;

import com.example.scheduler01.app.domain.Log;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LogRequest {
    private LocalDateTime created;
    private String log;

    public static Log to(LogRequest request) {
        return Log.builder()
                .body(request.getLog())
                .created(request.getCreated())
                .build();

    }
}
